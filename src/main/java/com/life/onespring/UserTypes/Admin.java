package com.life.onespring.UserTypes;

import com.life.onespring.Users;

public class Admin implements Users {

    private final String adminID;

    public Admin(){
        adminID = "Admin";
    }

    @Override
    public Admin login(){
        System.out.println("Admin Login");
        return this;
    }

    @Override
    public void getID(){
        System.out.println("Admin ID: " + adminID);
    }

    public void close(){
        System.out.println("Admin Exit");
        System.exit(0);
    }
}
