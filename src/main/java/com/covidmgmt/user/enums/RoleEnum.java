package com.covidmgmt.user.enums;

import java.util.Arrays;

public enum RoleEnum {

    HOSPITAL_ADMIN("HOSPITAL_ADMIN"),
    VACCINATION_ADMIN("VACCINATION_ADMIN"),
    PORTAL_ADMIN("PORTAL_ADMIN"),
    CITIZEN("CITIZEN"),
    UNKNOWN("Unknown");

    private final String code;

    private RoleEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static final RoleEnum getByCode(String Codes) {
        return Arrays.stream(RoleEnum.values())
                .findFirst().orElse(UNKNOWN);
    }
}

