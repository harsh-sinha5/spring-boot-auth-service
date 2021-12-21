package com.covidmgmt.user.dto;

public class HospitalData {

    private String hospitalId;
    private String branchId;
    private Location location;

    public HospitalData() {
    }

    public HospitalData(String hospitalId, String branchId, Location location) {
        this.hospitalId = hospitalId;
        this.branchId = branchId;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
