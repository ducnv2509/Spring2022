package DAO;

import Utils.JpaUtils;
import entity.AccountUser;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDao {
    public void insert(AccountUser u) {
        EntityManager em = JpaUtils.getEntityManager();

        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(u);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public void update(AccountUser user) {
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
            AccountUser user = em.find(AccountUser.class, userID);
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
        AccountUser user = em.find(AccountUser.class, userID);

    }


    public List<AccountUser> findAll() {
        String sql = "select u from AccountUser u";
        EntityManager em = JpaUtils.getEntityManager();
        TypedQuery<AccountUser> query = em.createQuery(sql, AccountUser.class);
        return query.getResultList();
    }

    public List<AccountUser> findAll(int page, int pageSize) {
        String sql = "select u from AccountUser u";
        EntityManager em = JpaUtils.getEntityManager();
        TypedQuery<AccountUser> query = em.createQuery(sql, AccountUser.class);
        query.setFirstResult(page * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

    public List<AccountUser> checkLogin(String userID, String password) {
        String sql = "select u from AccountUser u where u.userId = :userId and u.password = :password";
        EntityManager em = JpaUtils.getEntityManager();

        TypedQuery<AccountUser> query = em.createQuery(sql, AccountUser.class);
        query.setParameter("userId", userID);
        query.setParameter("password", password);
        return query.getResultList();
    }

    public List<AccountUser> findBuyFullName(String fullname) {
        String sql = "select u from AccountUser u where u.fullName like :fullname";
        EntityManager em = JpaUtils.getEntityManager();
        TypedQuery<AccountUser> query = em.createQuery(sql, AccountUser.class);
        query.setParameter("fullname", "%" + fullname + "%");

        return query.getResultList();
    }


    public int count() {
        String sql = "select count(u) from AccountUser u";
        EntityManager em = JpaUtils.getEntityManager();
        Query query = em.createQuery(sql);
        return ((Long) query.getSingleResult()).intValue();
    }
}
