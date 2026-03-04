package com.life.onespring.UserTypes;

import com.life.onespring.Users;
import org.springframework.beans.factory.annotation.Value;


public class Guest implements Users {

    private final String id;



    public Guest(){
        id = "Guest";
    }

    @Override
    public Guest login(){
    System.out.println("Guest Login");
    return this;
    }

    @Override
    public String getID(){
        System.out.println("Guest ID: " + id);
        return id;
    }
}
