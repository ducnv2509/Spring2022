package com.example.lab05;

import Dao.UserDao;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaProgram {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Lab05");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            User u = new User();
            u.setUserId("ducnv");
            u.setAdmin(true);
            u.setEmail("ducnvph14435@fpt.edu.vn");
            u.setFullname("Nguyen Van Duc");
            u.setPassword("123");
            entityManager.persist(u);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
//        create();
    }

    private static void create() {
        User u = new User();
        u.setUserId("ducnv");
        u.setAdmin(true);
        u.setEmail("ducnvph14435@fpt.edu.vn");
        u.setFullname("Nguyen Van Duc");
        u.setPassword("123");
        UserDao dao = new UserDao();
        dao.Insert(u);
        System.out.println("Ok");
    }

    private static void update() {
    }

    private static void delete() {
    }

    private static void findAll() {
    }

    //    private static void findByRole(boolean) {}
    private static void findByKeyword(String keywork) {
    }

    private static void findOne(String username, String password) {
    }

    private static void findPage(int page, int size) {
    }
}
