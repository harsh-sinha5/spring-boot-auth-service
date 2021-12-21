package com.covidmgmt.user.service;

import com.covidmgmt.user.repository.UserRepository;
import com.covidmgmt.user.security.CustomUserDetails;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<com.covidmgmt.user.model.User>  user = userRepository.findById(username);
        user.orElseThrow(() -> new UsernameNotFoundException("User not found:"+username));
        return user.map(CustomUserDetails::new).get();
        /*return new User(user.map(value -> value.getAadhaarNumber().toString())
                .orElse(Strings.EMPTY), user.isPresent() ? user.get().getPassword() : Strings.EMPTY ,
                new ArrayList<>(Collections.singleton(new SimpleGrantedAuthority(user.map(user1 -> user1.getRoles().getRoleName()).orElse(null)))));*/
    }

}
