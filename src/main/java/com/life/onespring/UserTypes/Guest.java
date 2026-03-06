package com.life.onespring.UserTypes;

import com.life.onespring.Users;
import jakarta.servlet.ServletContext;
import lombok.Data;
import java.util.Enumeration;
@Data
public class Guest implements Users {

    private String id;
    private long creationTime;
    private Guest obj;

    public Guest(){
        id = "defaultGuestID";
        creationTime = System.currentTimeMillis();
        obj = this;
    }

    @Override
    public Guest login(){
        System.out.println("Guest Logged In");
        obj.id = creationTime + "";
        return this;
    }

    @Override
    public String getId(){
        return id;
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
    public void setMaxInactiveInterval(int interval) {

    }

    @Override
    public int getMaxInactiveInterval() {
        return 0;
    }

    @Override
    public Object getAttribute(String name) {
        return null;
    }

    @Override
    public Enumeration<String> getAttributeNames() {
        return null;
    }

    @Override
    public void setAttribute(String name, Object value) {

    }

    @Override
    public void removeAttribute(String name) {

    }

    @Override
    public void invalidate() {

    }

    @Override
    public boolean isNew() {
        return false;
    }

    @Override
    public long getCreationTime(){
        return creationTime;
    }
}
