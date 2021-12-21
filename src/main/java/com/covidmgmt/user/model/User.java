package com.covidmgmt.user.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_login_id")
    private String userLoginId;
    @Column(name = "password")
    private String password;
    @OneToOne
    @JoinTable(name = "users_roles",
            joinColumns = {@JoinColumn(name = "users_id")},
            inverseJoinColumns = {@JoinColumn(name = "roles_id")}
    )
    private Roles roles;
    @Column(name = "city_name")
    private String cityName;
    @Column(name = "pin_code")
    private String pinCode;
    @Column(name = "hospital_id")
    private String hospitalId;
    @Column(name = "hospital_branch_id")
    private String hospitalBranchId;
    @Column(name = "hospital_pin_code")
    private String hospitalPinCode;
    @Column(name = "hospital_city_name")
    private String hospitalCityName;
    public User() {  }
    public User(String userLoginId, String password, Roles roles, String cityName, String pinCode) {
        this.userLoginId = userLoginId;
        this.password = password;
        this.roles = roles;
        this.cityName = cityName;
        this.pinCode = pinCode;
    }

    public User(String userLoginId, String password, Roles roles, String cityName, String pinCode, String hospitalId, String hospitalBranchId, String hospitalPinCode, String hospitalCityName) {
        this.userLoginId = userLoginId;
        this.password = password;
        this.roles = roles;
        this.cityName = cityName;
        this.pinCode = pinCode;
        this.hospitalId = hospitalId;
        this.hospitalBranchId = hospitalBranchId;
        this.hospitalPinCode = hospitalPinCode;
        this.hospitalCityName = hospitalCityName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
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

    public String getUserLoginId() {
        return userLoginId;
    }

    public void setUserLoginId(String userLoginId) {
        this.userLoginId = userLoginId;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalBranchId() {
        return hospitalBranchId;
    }

    public void setHospitalBranchId(String hospitalBranchId) {
        this.hospitalBranchId = hospitalBranchId;
    }

    public String getHospitalPinCode() {
        return hospitalPinCode;
    }

    public void setHospitalPinCode(String hospitalPinCode) {
        this.hospitalPinCode = hospitalPinCode;
    }

    public String getHospitalCityName() {
        return hospitalCityName;
    }

    public void setHospitalCityName(String hospitalCityName) {
        this.hospitalCityName = hospitalCityName;
    }
}
