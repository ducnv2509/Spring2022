package Dao;

import Utils.JpaUtils;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserDao {
    public void Insert(User user) {
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
