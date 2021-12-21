package com.covidmgmt.user.service;

import com.covidmgmt.user.dto.HospitalLocDetails;
import org.springframework.stereotype.Service;
import com.covidmgmt.user.dto.UserData;

public interface AdminService {
    public void postadminuserinfoDetails(String xTokenID, UserData userData, String role);

    HospitalLocDetails getHospitalLocDetails(String hospitalName);

}
