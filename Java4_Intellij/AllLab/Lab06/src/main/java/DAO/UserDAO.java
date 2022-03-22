package DAO;

import Utils.JpaUtils;
import enitity.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDAO extends DAOM<Users, String> {
    @Override
    public void insert(Users entity) {
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(entity);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public void update(Users entity) {
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(entity);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(String key) {
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            Users user = em.find(Users.class, key);
            if (user != null) {
                em.remove(user);
            } else {
                throw new Exception("This user does not exits");
            }
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Users> findAll() {
        EntityManager em = JpaUtils.getEntityManager();
        TypedQuery<Users> query = em.createQuery("select u from Users u", Users.class);
        return query.getResultList();
    }

    @Override
    public Users findByID(String key) {
        EntityManager em = JpaUtils.getEntityManager();
        String sql = "Select o from Users o where o.id = :userID";
        TypedQuery<Users> query = em.createQuery(sql, Users.class);
        query.setParameter("userID", key);
        return query.getSingleResult();
    }
}
