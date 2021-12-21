package com.covidmgmt.user.dto;

import java.util.List;

public class BranchInfo {

    private String branchId;
    private List<BedInfo> beds;
    private Location location;

    public BranchInfo() {}

    public BranchInfo(String branchId, List<BedInfo> beds, Location location) {
        this.branchId = branchId;
        this.beds = beds;
        this.location = location;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public List<BedInfo> getBeds() {
        return beds;
    }

    public void setBeds(List<BedInfo> beds) {
        this.beds = beds;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
