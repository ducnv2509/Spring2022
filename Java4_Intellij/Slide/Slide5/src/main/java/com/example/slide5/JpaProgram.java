package com.example.slide5;

import Dao.UserDao;
import entity.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaProgram {
    public static void main(String[] args) {
        create();
    }

    private static void create() {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Lab05");
//        EntityManager em = emf.createEntityManager();

        try {
//            em.getTransaction().begin();
//            em.getTransaction().commit();
//            System.out.println("Thêm mới thành công");
            UserEntity u = new UserEntity();
            u.setUserId("ducnv");
            u.setAdmin(true);
            u.setEmail("ducnvph14435@fpt.edu.vn");
            u.setFullname("Nguyen Van Duc");
            u.setPassword("123");
            UserDao dao = new UserDao();
            dao.insert(u);
            System.out.println("ok");
        } catch (
                Exception exception) {
//            em.getTransaction().rollback();
//            System.out.println("them error");
        }
//        emf.close();
//        em.close();
    }


}
