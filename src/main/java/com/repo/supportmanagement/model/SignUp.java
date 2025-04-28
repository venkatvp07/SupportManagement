package com.repo.supportmanagement.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "signup")
public class SignUp {

    @Id
    @GeneratedValue
    private Long signupId;

    @Column(nullable = false , unique = true)
    private String emailId;

    @Column(nullable = false,length = 30)
    private String password;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @org.springframework.data.annotation.Transient
    private String oldPassword;

    public Long getSignupId() {
        return signupId;
    }

    public void setSignupId(Long signupId) {
        this.signupId = signupId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
}
