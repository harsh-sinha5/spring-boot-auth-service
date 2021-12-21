package com.covidmgmt.user.dto;

public class BedInfo {

    private String bedId;
    private String bedFacility;
    private String bedType;

    public String getBedId() {
        return bedId;
    }

    public void setBedId(String bedId) {
        this.bedId = bedId;
    }

    public String getBedFacility() {
        return bedFacility;
    }

    public void setBedFacility(String bedFacility) {
        this.bedFacility = bedFacility;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }
}
