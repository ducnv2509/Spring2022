package DAO;

import Utils.JpaUtils;
import entity.Category;
import entity.Demo;
import entity.OrderStates;
import entity.Orderdetails;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class demoDAO {
    public void insert(OrderStates user) {
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
