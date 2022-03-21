package com.example.lab05_duc2509;

import entity.ListUsers;

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
            ListUsers user = new ListUsers();
            user.setPassword("ducn123");
            user.setUserId("ducnv12311");
            user.setFullName("Nguyen Van Duc");
            user.setAdmin(true);
            user.setEmail("ducnv12312@gmail.com");
            entityManager.persist(user);
            transaction.commit();
        }catch(Exception e){
            System.out.println(e);
        }finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
