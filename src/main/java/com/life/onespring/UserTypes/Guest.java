package com.life.onespring.UserTypes;

import com.life.onespring.Users;
import jakarta.servlet.ServletContext;
import lombok.Data;

import java.util.Enumeration;

@Data
public class Guest implements Users {

    private String id;

    public Guest(){
        id = "defaultGuestID";
    }

    @Override
    public Guest login(){
        id = "guestID";
    System.out.println("Guest Logged In");
    return this;
    }

    @Override
    public String getId(){
        return id;
    }

    @Override
    public long getCreationTime() {
        return 0;
    }

    @Override
    public long getLastAccessedTime() {
        return 0;
    }

    @Override
    public ServletContext getServletContext() {
        return null;
    }

    @Override
    public void setMaxInactiveInterval(int i) {

    }

    @Override
    public int getMaxInactiveInterval() {
        return 0;
    }

    @Override
    public Object getAttribute(String s) {
        return null;
    }

    @Override
    public Enumeration<String> getAttributeNames() {
        return null;
    }

    @Override
    public void setAttribute(String s, Object o) {

    }

    @Override
    public void removeAttribute(String s) {

    }

    @Override
    public void invalidate() {

    }

    @Override
    public boolean isNew() {
        return false;
    }
}
