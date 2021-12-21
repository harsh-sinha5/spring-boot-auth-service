package com.covidmgmt.user.mapper;

import com.covidmgmt.user.dto.CitizenData;
import com.covidmgmt.user.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "password", source = "pwd")
    @Mapping(target = "hospitalId", ignore = true)
    @Mapping(target = "hospitalBranchId", ignore = true)
    @Mapping(target = "hospitalPinCode", ignore = true)
    @Mapping(target = "hospitalCityName", ignore = true)
    User toUserEntity(CitizenData citizenData);

//    default User toUserEntities(UserDTO userDTO){
//        User user = new User();
//        user.setAadhaarNumber(userDTO.getAadhaarNumber());
//        user.setPassword(userDTO.getPassword());
//        user.setRole(RoleEnum.getByCode(user.getRole()).getCode());
//        return user;
//    }
}
