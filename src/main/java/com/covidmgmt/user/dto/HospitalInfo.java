package com.covidmgmt.user.dto;

import java.util.List;

public class HospitalInfo {

    private  String name;
    private List<BranchInfo> branches;

    public HospitalInfo(){}

    public HospitalInfo(String name, List<BranchInfo> branches) {
        this.name = name;
        this.branches = branches;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BranchInfo> getBranches() {
        return branches;
    }

    public void setBranches(List<BranchInfo> branches) {
        this.branches = branches;
    }
}
