package com.covidmgmt.user.interfaces;

import com.covidmgmt.user.dto.*;
import com.covidmgmt.user.enums.RoleEnum;
import com.covidmgmt.user.service.AdminService;
import com.covidmgmt.user.service.UserLoginService;
import com.covidmgmt.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.annotation.security.RolesAllowed;
import java.lang.Error;
import com.covidmgmt.user.dto.UserData;
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    UserLoginService userLoginService;

    @Autowired
    private AdminService adminService;

    @PostMapping("/_signup")
    @CrossOrigin(origins = "*")
    @ApiOperation(value = "Api for Citizen sign-up",
            notes = "This API will Sign up general citizens so that they can book the bed booking for their ward and can able to schedule vaccination. " +
                    "Default role which will be consider for citizen is CITIZEN")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns true or false based on the successful and unsuccessful posting", response = Boolean.class),
            @ApiResponse(code = 400, message = "Invalid input", response = Error.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = Error.class),
            @ApiResponse(code = 405, message = "Validation Exception", response = Error.class) })
    public Boolean signUp(@ApiParam(value = "Citizen Data for Signup",required=true)@RequestBody CitizenData citizenData) throws Exception {
        return userService.signUp(citizenData);
    }

    @PutMapping("/_login")
    @CrossOrigin(origins = "*")
    @ApiOperation(value = "Logins the user",
            notes = "A valid user with valid user id and password.", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Token string", response = String.class),
            @ApiResponse(code = 400, message = "Invalid input", response = Error.class),
            @ApiResponse(code = 404, message = "School Not Found", response = Error.class),
            @ApiResponse(code = 405, message = "Validation Exception", response = Error.class) })
    public String login(@RequestBody User user) throws Exception {
        return userLoginService.login(user);
    }

    @GetMapping("/hospitalDetails/{hospitalName}")
    @CrossOrigin(origins = "*")
    @ApiOperation(value = "", notes = "Return the hospital info covid portal admin log in to create other admins", response = HospitalLocDetails.class, tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns Hospital name with branches Id and and Branches pin code.", response = HospitalLocDetails.class),
            @ApiResponse(code = 400, message = "Invalid input", response = Error.class),
            @ApiResponse(code = 404, message = "Not Found", response = Error.class),
            @ApiResponse(code = 405, message = "Validation Exception", response = Error.class) })
    public HospitalLocDetails getHospitalName(@PathVariable String hospitalName){
        return adminService.getHospitalLocDetails(hospitalName);
    }

    @PutMapping("/_logout")
    @CrossOrigin(origins = "*")
    @ApiOperation(value = "", notes = "Logout user", response = Boolean.class, tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns true or false based on the successful and unsuccessful posting", response = Boolean.class),
            @ApiResponse(code = 400, message = "Invalid input", response = Error.class),
            @ApiResponse(code = 404, message = "Not Found", response = Error.class),
            @ApiResponse(code = 405, message = "Validation Exception", response = Error.class) })
    public Boolean logout(@ApiParam(value = "A JWT token which will be returned as part of login and will have user role details." ,required=true) @RequestHeader(value="X-Token-ID", required=true) String xTokenID){
        return userLoginService.logout(xTokenID);
    }

    @PostMapping("/_create")
    @CrossOrigin(origins = "*")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns true or false based on the successfull and unsuccessfull posting", response = Boolean.class),
            @ApiResponse(code = 400, message = "Invalid input", response = Error.class),
            @ApiResponse(code = 404, message = "Not Found", response = Error.class),
            @ApiResponse(code = 405, message = "Validation Exception", response = Error.class) })

    public Boolean createAdmins(@ApiParam(value = "A JWT token which will be returned as part of login and will have user role details." ,required=true ) @RequestHeader(value="X-Token-ID" ,required=true) String xTokenID, @ApiParam(value = "Patient information to book the bed."  ,required=true)   @RequestBody UserData userData, @ApiParam(value = "role for the user", allowableValues = "HOSPITAL_ADMIN, VACCINATION_ADMIN", defaultValue = "HOSPITAL_ADMIN")  @RequestParam(value = "role", required = false, defaultValue="HOSPITAL_ADMIN") String role){
        adminService.postadminuserinfoDetails( xTokenID, userData, role);
        return true;
    }



}
