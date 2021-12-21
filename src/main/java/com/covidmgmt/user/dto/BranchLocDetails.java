package com.covidmgmt.user.dto;

public class BranchLocDetails {

    private String branchId;
    private String pinCode;

    public BranchLocDetails() {
    }

    public BranchLocDetails(String branchId, String pinCode) {
        this.branchId = branchId;
        this.pinCode = pinCode;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }
}
