package com.covidmgmt.user.repository;

//import com.covidmgmt.user.model.UserInfo;
import com.covidmgmt.user.model.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRolesRepository  extends JpaRepository<UserRoles, String> {

}