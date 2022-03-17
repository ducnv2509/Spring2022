package com.example.slide5;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaProgram {
    public static void main(String[] args) {
        create();
    }

    private static void create() {
    }

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Lab05");
//    EntityManager em = emf.createEntityManager();
//
//    try
//
//    {
//        em.getTransaction().begin();
//
//
//        em.getTransaction().commit();
//
//    }catch(
//    Exception exception)
//
//    {
//        em.getTransaction().rollback();
//        System.out.println("them error");
//    }
}
