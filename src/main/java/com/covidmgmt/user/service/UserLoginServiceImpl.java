package com.covidmgmt.user.service;

import com.covidmgmt.user.dto.LoginDTO;
import com.covidmgmt.user.dto.LoginResponse;
import com.covidmgmt.user.dto.User;
import com.covidmgmt.user.exception.InvalidTokenException;
import com.covidmgmt.user.exception.UserNotFoundException;
import com.covidmgmt.user.repository.UserRepository;
import com.covidmgmt.user.security.CustomUserDetails;
import com.covidmgmt.user.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.csrf.InvalidCsrfTokenException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;


@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String login(User user) throws Exception {

        Optional<com.covidmgmt.user.model.User> userEntity = userRepository.findById(user.getUserLoginId());
        userEntity.orElseThrow(()-> new UserNotFoundException("User doesn't exist"));

        HttpHeaders headers = new HttpHeaders();
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUserLoginId(), user.getPwd())
            );
        } catch(BadCredentialsException  e) {
              throw new Exception("Incorrect username and password", e);
        }
        final CustomUserDetails userDetails = userDetailsServiceImpl
                .loadUserByUsername(user.getUserLoginId());

        final String jwt  = jwtTokenUtil.generateToken(userDetails);
        return jwt ;
    }

    @Override
    public Boolean logout(String xTokenID) {
        try {
            CustomUserDetails userDetails = userDetailsServiceImpl
                    .loadUserByUsername(jwtTokenUtil.extractUserName(xTokenID));
            return jwtTokenUtil.validateToken(xTokenID, userDetails);
        } catch (Exception e){
            throw  new InvalidTokenException("Invalid Token");
        }
    }
}
