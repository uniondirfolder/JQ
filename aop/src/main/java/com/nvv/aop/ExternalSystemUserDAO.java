package com.nvv.aop;

import org.springframework.stereotype.Component;

@Component
public class ExternalSystemUserDAO {
    public void addUser() {
        System.out.println("New External User added");
    }
}
