package com.repo.supportmanagement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Long userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false , unique = true)
    private String emailId;

    @Column(nullable = false)
    private Integer userType;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String toString() {
        return "User name : " + getName() + "  ::  Email Id : " +getEmailId();
    }
}
