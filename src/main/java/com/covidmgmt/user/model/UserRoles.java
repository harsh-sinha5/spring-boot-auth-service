package com.covidmgmt.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users_roles")
public class UserRoles {
    @Id
    @Column(name = "users_id")
    private String useridaadhar;


    @Column(name = "roles_id")
    private Long roleId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getUseridaadhar() {
        return useridaadhar;
    }

    public void setUseridaadhar(String useridaadhar) {
        this.useridaadhar = useridaadhar;
    }


}
