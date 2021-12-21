package com.covidmgmt.user.dto;

public class CitizenData {

    private String userLoginId;
    private String pwd;
    private String confirmPwd;
    private String cityName;
    private String pinCode;

    public CitizenData() {
    }

    public CitizenData(String userLoginId, String pwd, String confirmPwd, String cityName, String pinCode) {
        this.userLoginId = userLoginId;
        this.pwd = pwd;
        this.confirmPwd = confirmPwd;
        this.cityName = cityName;
        this.pinCode = pinCode;
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

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "CitizenData{" +
                "userLoginId='" + userLoginId + '\'' +
                ", pwd='" + pwd + '\'' +
                ", confirmPwd='" + confirmPwd + '\'' +
                ", cityName='" + cityName + '\'' +
                ", pinCode='" + pinCode + '\'' +
                '}';
    }
}
