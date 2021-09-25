package com.nvv.d20210926.implts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class UserAop {
    @Value("${userAop.name}")
    private String name;
    private int candyCount;
    private Role role = Role.USER;

    @Autowired
    private PocketLeft pocketLeft;
    @Autowired
    private PocketRight pocketRight;

    public PocketLeft getPocketLeft() {
        return pocketLeft;
    }

    public int getCandyCount() {
        return candyCount;
    }

    public void setCandyCount(int candyCount) {
        this.candyCount = candyCount;
    }

    public void setPocketLeft(PocketLeft pocketLeft) {
        this.pocketLeft = pocketLeft;
    }

    public PocketRight getPocketRight() {
        return pocketRight;
    }

    public void setPocketRight(PocketRight pocketRight) {
        this.pocketRight = pocketRight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UserAop getCurrentUser(){
        UserAop userAop = this;
        return userAop;
    }

    enum Role {
        ADMIN,
        USER
    }
}
