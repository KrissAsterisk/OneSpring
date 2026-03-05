package com.life.onespring.UserTypes;

import com.life.onespring.Users;
import jakarta.servlet.ServletContext;
import lombok.Data;

import java.util.Enumeration;

@Data
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
    public long getCreationTime() {
        return 0;
    }

    @Override
    public String getId(){
        System.out.println("Admin ID: " + adminID);
        return adminID;
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
