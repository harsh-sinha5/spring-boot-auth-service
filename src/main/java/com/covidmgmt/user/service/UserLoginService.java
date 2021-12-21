package com.covidmgmt.user.service;

import com.covidmgmt.user.dto.LoginDTO;
import com.covidmgmt.user.dto.LoginResponse;
import com.covidmgmt.user.dto.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface UserLoginService {

    String login(User user) throws Exception;
    Boolean logout(String xTokenID);
}
