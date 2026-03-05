package com.life.onespring;

import jakarta.servlet.http.HttpSession;

public interface Users extends HttpSession {

    Users login();
    String getId();
}
