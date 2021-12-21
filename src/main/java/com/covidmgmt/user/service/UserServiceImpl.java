package com.covidmgmt.user.service;

import com.covidmgmt.user.dto.CitizenData;
import com.covidmgmt.user.enums.RoleEnum;
import com.covidmgmt.user.exception.IllegalUserIdException;
import com.covidmgmt.user.exception.UserExistsException;
import com.covidmgmt.user.mapper.UserMapper;
import com.covidmgmt.user.model.Roles;
import com.covidmgmt.user.model.User;
import com.covidmgmt.user.repository.RolesRepository;
import com.covidmgmt.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final String CITIZEN  = "Citizen";

    @Autowired
    UserMapper userMapper;
   @Autowired
    private UserRepository userRepository;
   @Autowired
   private RolesRepository rolesRepository;

    @Override
    public Boolean signUp(CitizenData citizenData) throws Exception {

        if(16 < citizenData.getUserLoginId().length()){ throw new IllegalUserIdException("User Id is greater than 16 characters");}
        User user = userMapper.toUserEntity(citizenData);
        List<String>  userLoginIds = userRepository.findAll().stream().map(User::getUserLoginId).collect(Collectors.toList());
        Optional<Roles> roles;
        if(!userLoginIds.contains(citizenData.getUserLoginId())) {
            roles = rolesRepository.findByRoleName(RoleEnum.CITIZEN.getCode());
            user.setRoles(roles.isPresent() ? roles.get() : null);
            userRepository.save(user);
        }
        else{
            throw new UserExistsException("User already exists");
        }
         return  true;


     /*   User user1 = userRepository.getById(userDTO.getAadhaarNumber());
        boolean unHashedPwd = SCryptUtil.check( userDTO.getPassword(), user1.getPassword());
        System.out.println(unHashedPwd);*/
    }


}
