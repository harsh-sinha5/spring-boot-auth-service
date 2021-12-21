package com.covidmgmt.user.dto;

public class UserData {

    private String userLoginId;
    private String pwd;
    private String confirmPwd;
    private HospitalData hospitalData;

    public UserData() {
    }

    public UserData(String userLoginId, String pwd, String confirmPwd, HospitalData hospitalData) {
        this.userLoginId = userLoginId;
        this.pwd = pwd;
        this.confirmPwd = confirmPwd;
        this.hospitalData = hospitalData;
    }

    public String getUserLoginId() {
        return userLoginId;
    }

    public void setUserLoginId(String userLoginId) {
        this.userLoginId = userLoginId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getConfirmPwd() {
        return confirmPwd;
    }

    public void setConfirmPwd(String confirmPwd) {
        this.confirmPwd = confirmPwd;
    }

    public HospitalData getHospitalData() {
        return hospitalData;
    }

    public void setHospitalData(HospitalData hospitalData) {
        this.hospitalData = hospitalData;
    }
}
