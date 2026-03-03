package com.life.onespring.UserTypes;

import com.life.onespring.Users;

public class Guest implements Users {

    private final String guestID;

    public Guest(){
        guestID = "Guest";
    }

    @Override
    public Guest login(){
    System.out.println("Guest Login");
    return this;
    }

    @Override
    public void getID(){
        System.out.println("Guest ID: " + guestID);
    }
}
