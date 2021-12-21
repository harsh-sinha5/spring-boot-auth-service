package com.covidmgmt.user.integration;

import com.covidmgmt.user.dto.HospitalInfo;
import org.springframework.stereotype.Service;

public interface BedAvailabilityIntegrationService {

    HospitalInfo getHospitalBranches(String hospitalName);
}
