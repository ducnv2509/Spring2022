package com.example.lab5_main;

import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaProgram {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            User user = new User();
            user.setPassword("ducn123");
            user.setUserId("ducnv12311");
            user.setFullname("Nguyen Van Duc");
            user.setAdmin(true);
            user.setEmail("ducnv12312@gmail.com");
            entityManager.persist(user);
            transaction.commit();
        }finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
