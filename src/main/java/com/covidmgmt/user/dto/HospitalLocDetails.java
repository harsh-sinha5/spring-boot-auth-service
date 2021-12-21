package com.covidmgmt.user.dto;

import java.util.List;

public class HospitalLocDetails {

    private String hospitalName;
    private List<BranchLocDetails> branchLocDetails;

    public HospitalLocDetails() {}

    public HospitalLocDetails(String hospitalName, List<BranchLocDetails> branchLocDetails) {
        this.hospitalName = hospitalName;
        this.branchLocDetails = branchLocDetails;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public List<BranchLocDetails> getBranchLocDetails() {
        return branchLocDetails;
    }

    public void setBranchLocDetails(List<BranchLocDetails> branchLocDetails) {
        this.branchLocDetails = branchLocDetails;
    }
}
