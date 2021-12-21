package com.covidmgmt.user.security;

import com.covidmgmt.user.model.User;
import org.apache.logging.log4j.util.Strings;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {

    private String userName;
    private String password;
    private List<GrantedAuthority> grantedAuthorities;
    private String cityName;
    private String pinCode;
    private String hospitalId;
    private String branchId;

    public CustomUserDetails(User user) {
        this.userName = user.getUserLoginId();
        this.password = user.getPassword();
        this.grantedAuthorities = Arrays.stream(user.getRoles().getRoleName().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        this.pinCode = Strings.isEmpty(user.getPinCode()) ? user.getHospitalPinCode() : user.getPinCode();
        this.cityName = Strings.isNotEmpty(user.getCityName()) ? user.getCityName() : user.getHospitalCityName();
        this.hospitalId = user.getHospitalId();
        this.branchId = user.getHospitalBranchId();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getPinCode() {
        return pinCode;
    }

    public String getBranchId() {
        return branchId;
    }

    public String getCityName() {
        return cityName;
    }

    public String getHospitalId() {
        return hospitalId;
    }
}
