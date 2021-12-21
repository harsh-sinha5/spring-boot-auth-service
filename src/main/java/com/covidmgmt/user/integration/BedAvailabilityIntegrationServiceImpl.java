package com.covidmgmt.user.integration;

import com.covidmgmt.user.dto.HospitalInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class BedAvailabilityIntegrationServiceImpl implements BedAvailabilityIntegrationService {

    @Autowired
    private WebClient.Builder webClientBuilder;
    @Value("${bas.base.url}")
    private String baseUrl;

    @Override
    public HospitalInfo getHospitalBranches(String hospitalName) {
        return  webClientBuilder.baseUrl(baseUrl)
                .build()
                .get()
                .uri(uriBuilder -> uriBuilder.path("/bas/{hospitalName}/_getHospitalBranches")
                .build(hospitalName))
                .retrieve()
                .bodyToMono(HospitalInfo.class)
                .block();
    }
}
