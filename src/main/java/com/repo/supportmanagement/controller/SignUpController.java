package com.repo.supportmanagement.controller;

import com.repo.supportmanagement.model.SignUp;
import com.repo.supportmanagement.repository.SignUpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SignUpController {

    @Autowired
    private SignUpRepo signUpRepo;

    @RequestMapping("/signup")
    @PostMapping
    public String signUp(@RequestBody SignUp signUp) {
        Optional<SignUp> signUpOpt = signUpRepo.findUserByEmail(signUp.getEmailId());
        if(!signUpOpt.isEmpty()) {
            return "Users already Signed Up.";
        }
        signUpRepo.save(signUp);
        return "Sign Up successfully";
    }

    @RequestMapping("/login/changepassword")
    @PostMapping
    public String changePasswrod(@RequestBody SignUp signUp) {
        Optional<SignUp> signUpOpt = signUpRepo.findUserByEmail(signUp.getEmailId());
        if(signUpOpt.isEmpty()) {
            return "user not found";
        }
        SignUp dbValue = signUpOpt.get();
        if(dbValue.getPassword().equals(signUp.getOldPassword())) {
            signUp.setSignupId(dbValue.getSignupId());
            signUpRepo.save(signUp);
            return "Password changed successfully";
        }else {
            return "Old password is wrong";
        }
    }

    @RequestMapping("/login")
    @PostMapping
    public String login(@RequestBody SignUp signUp) {
        Optional<SignUp> signUpOpt = signUpRepo.findUserByEmail(signUp.getEmailId());
        if(signUpOpt.isEmpty()) {
            return "user not found";
        }
        SignUp dbValue = signUpOpt.get();
        if(dbValue.getPassword().equals(signUp.getPassword())) {
            return "Login Successfully";
        }else {
            return "Login failed";
        }
    }
}
