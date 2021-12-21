package com.covidmgmt.user.service;
import com.covidmgmt.user.exception.InvalidTokenException;
import com.covidmgmt.user.model.Roles;
import com.covidmgmt.user.model.User;
import com.covidmgmt.user.model.UserRoles;
import com.covidmgmt.user.repository.RolesRepository;
import com.covidmgmt.user.repository.UserRepository;
import com.covidmgmt.user.repository.UserRolesRepository;
import com.covidmgmt.user.dto.*;
import com.covidmgmt.user.integration.BedAvailabilityIntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;
import com.covidmgmt.user.dto.UserData;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    BedAvailabilityIntegrationService bedAvailabilityIntegrationService;
    @Autowired
    RolesRepository rolesRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRolesRepository userRolesRepository;

    @Override
    public HospitalLocDetails getHospitalLocDetails(String hospitalName) {

        HospitalInfo hospitalInfo = bedAvailabilityIntegrationService.getHospitalBranches(hospitalName);
       List<BranchInfo> branches = hospitalInfo.getBranches();
       List<BranchLocDetails> branchLocDetailsList  = branches.stream().map(branchInfo ->  new BranchLocDetails(branchInfo.getBranchId(), branchInfo.getLocation().getPinCode())
       ).collect(Collectors.toList());
        HospitalLocDetails hospitalLocDetails = new HospitalLocDetails(hospitalInfo.getName(), branchLocDetailsList);
        return  hospitalLocDetails;
    }

    @Override
    public void postadminuserinfoDetails(String xTokenID, UserData userData, String role) {
        try {
           User userobj= new User();
            userobj.setUserLoginId(userData.getUserLoginId());
            userobj.setPassword(userData.getPwd());
            userobj.setHospitalId(userData.getHospitalData().getHospitalId());
            userobj.setHospitalBranchId(userData.getHospitalData().getBranchId());
            userobj.setHospitalPinCode(userData.getHospitalData().getLocation().getPinCode());
            userobj.setHospitalCityName(userData.getHospitalData().getLocation().getCityName());
            userRepository.save(userobj) ;

            Optional<Roles> roleuser  = Optional.ofNullable(rolesRepository.findByRoleName(role).orElse(null));
            if(roleuser.isPresent()) {
                Roles rrr = roleuser.get();
                Long xyz= rrr.getId();
                UserRoles userrole = new UserRoles();
                userrole.setUseridaadhar(userData.getUserLoginId());
                userrole.setRoleId(Long.valueOf(xyz));
                userRolesRepository.save(userrole);
            }


        } catch (Exception e) {
            throw  new InvalidTokenException("HospitalUserData Not saved !!");
        }
    }
}
