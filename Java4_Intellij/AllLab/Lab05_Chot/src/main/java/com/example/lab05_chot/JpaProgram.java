package com.example.lab05_chot;

import DAO.UserDAO;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaProgram {
    public static void main(String[] args) {
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        EntityTransaction transaction = entityManager.getTransaction();
//        try {
//            transaction.begin();
//            User user = new User();
//            user.setPassword("demone");
//            user.setUserId("12312");
//            user.setFullname("Nguyen Van Minh");
//            user.setAdmin(false);
//            user.setEmail("ducnas@gmail.com");
//            entityManager.persist(user);
//            System.out.println("Done");
//            transaction.commit();
//        }catch(Exception e){
//            System.out.println(e);
//        }finally {
//            if(transaction.isActive()){
//                transaction.rollback();
//            }
//            entityManager.close();
//            entityManagerFactory.close();
//        }
        User user = new User();
        user.setUserId("US01");
        user.setEmail("ducnv123@gmail.com");
        user.setPassword("123131");
        user.setFullname("Nguyễn văn Đức");
        user.setAdmin(true);
        UserDAO uDao = new UserDAO();
        uDao.insert(user);
        System.out.println("Done");
    }
}
