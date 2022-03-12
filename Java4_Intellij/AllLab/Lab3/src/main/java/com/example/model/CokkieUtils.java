package com.example.model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CokkieUtils {
    public static Cookie add(String name, String value, int hours, HttpServletResponse response) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(hours * 60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);
        return cookie;
    }

    public static String get(String name, HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equalsIgnoreCase(name)) {
                    return cookie.getValue();
                }
            }
        }
        return "";
    }
}
