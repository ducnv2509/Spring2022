package DAO;

import entity.User;
import utils.JpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDAO {
    public void insert(User user) {
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

    public void update(User user) {
        EntityManager em = JpaUtils.getEntityManager();

        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(user);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public void delete(String userID) throws Exception {
        EntityManager em = JpaUtils.getEntityManager();

        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            User user = em.find(User.class, userID);
            if (user != null) {
                em.remove(user);
            } else {
                throw new Exception("Not find");
            }
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public void findByID(String userID) {
        EntityManager em = JpaUtils.getEntityManager();
        User user = em.find(User.class, userID);

    }


    public List<User> findAll() {
        String sql = "";
        EntityManager em = JpaUtils.getEntityManager();
        TypedQuery<User> query = em.createQuery(sql, User.class);
        return query.getResultList();
    }

    public List<User> findAll(int page, int pageSize) {
        String sql = "select  u from 'User' u";
        EntityManager em = JpaUtils.getEntityManager();
        TypedQuery<User> query = em.createQuery(sql, User.class);
        query.setFirstResult(page * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

    public List<User> checkLogin(String userID, String password) {
        String sql = "select u from [User] u where u.userId = :userId and u.pasword = :password";
        EntityManager em = JpaUtils.getEntityManager();

        TypedQuery<User> query = em.createQuery(sql, User.class);
        query.setParameter("userId", userID);
        query.setParameter("password", password);
        return query.getResultList();
    }

    public List<User> findBuyFullName(String fullname) {
        String sql = "select u from 'User' u where u fullname like :fullname";
        EntityManager em = JpaUtils.getEntityManager();
        TypedQuery<User> query = em.createQuery(sql, User.class);
        query.setParameter("fullname", "%" + fullname + "%");

        return query.getResultList();
    }


    public int count() {
        String sql = "select count(u) from 'User'";
        EntityManager em = JpaUtils.getEntityManager();
        Query query = em.createQuery(sql);
        return ((Long) query.getSingleResult()).intValue();
    }
}
