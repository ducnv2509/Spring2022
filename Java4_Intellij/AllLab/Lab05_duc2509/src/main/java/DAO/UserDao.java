package DAO;

import Utils.JpaUtils;
import entity.ListUsers;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDao {
    public void insert(ListUsers user) {
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

    public void update(ListUsers user) {
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
            ListUsers user = em.find(ListUsers.class, userID);
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

    public ListUsers findByID(String userID) {
        EntityManager em = JpaUtils.getEntityManager();
        return em.find(ListUsers.class, userID);
    }


    public List<ListUsers> findAll() {
        String sql = "select u from ListUsers u";
        EntityManager em = JpaUtils.getEntityManager();
        TypedQuery<ListUsers> query = em.createQuery(sql, ListUsers.class);
        return query.getResultList();
    }

    public List<ListUsers> findAll(int page, int pageSize) {
        String sql = "select  u from ListUsers u";
        EntityManager em = JpaUtils.getEntityManager();
        TypedQuery<ListUsers> query = em.createQuery(sql, ListUsers.class);
        query.setFirstResult(page * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

    public List<ListUsers> checkLogin(String userID, String password) {
        String sql = "select u from ListUsers u where u.userId = :userId and u.password = :password";
        EntityManager em = JpaUtils.getEntityManager();

        TypedQuery<ListUsers> query = em.createQuery(sql, ListUsers.class);
        query.setParameter("userId", userID);
        query.setParameter("password", password);
        return query.getResultList();
    }

    public List<ListUsers> findBuyFullName(String fullname) {
        String sql = "select u from ListUsers u where u.fullName like :fullname";
        EntityManager em = JpaUtils.getEntityManager();
        TypedQuery<ListUsers> query = em.createQuery(sql, ListUsers.class);
        query.setParameter("fullname", "%" + fullname + "%");
        return query.getResultList();
    }


    public int count() {
        String sql = "select count(u) from ListUsers u";
        EntityManager em = JpaUtils.getEntityManager();
        Query query = em.createQuery(sql);
        return ((Long) query.getSingleResult()).intValue();
    }
}
