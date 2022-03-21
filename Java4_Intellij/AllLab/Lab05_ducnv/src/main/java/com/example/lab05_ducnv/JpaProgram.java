package com.example.lab05_ducnv;

import DAO.UserDao;
import entity.AccountUser;


public class JpaProgram {
    public static void main(String[] args) {
        AccountUser user = new AccountUser();
        user.setUserId("US01");
        user.setEmail("ducnv123@gmail.com");
        user.setPassword("123131");
        user.setFullName("Nguyễn văn Đức");
        user.setAdmin(true);
        UserDao uDao = new UserDao();
        uDao.insert(user);
        System.out.println("Done");
    }
}
