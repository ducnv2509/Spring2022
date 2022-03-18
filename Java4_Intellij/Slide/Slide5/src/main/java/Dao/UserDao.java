package Dao;

import entity.UserEntity;
import utils.JpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserDao {
    public void insert(UserEntity user) {
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            em.persist(user);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}
