package com.covidmgmt.user.service;

import com.covidmgmt.user.dto.CitizenData;

public interface UserService {

    Boolean signUp(CitizenData citizenData) throws Exception;
}
