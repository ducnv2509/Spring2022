package DAO;

import Utils.BaseService;
import Utils.EncryptUtils;
import Utils.JpaUtils;
import entity.Products;
import entity.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO extends DAO<Users, Integer> {
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
    public void delete(Integer key) throws Exception {
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            Users user = em.find(Users.class, key);
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

    @Override
    public List<Users> findAll() {
        String sql = "select u from Users u order by u.id desc";
        EntityManager em = JpaUtils.getEntityManager();
        TypedQuery<Users> query = em.createQuery(sql, Users.class);
        return query.getResultList();
    }

    @Override
    public Users findByID(Integer key) {
        EntityManager em = JpaUtils.getEntityManager();
        return em.find(Users.class, key);
    }

//    public Users login(String users, String pass) {
//        String sql = "select  * from users where username = ? and password = ?";
//        try {
//            Connection con = BaseService.getConnection();
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, users);
//            ps.setString(2, pass);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                return (new Users(
//                        rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
//                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getBoolean(8),
//                        rs.getString(9), rs.getDate(10), rs.getBoolean(11), rs.getBoolean(12)
//                ));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public List<Users> checkLogin(String userID, String password) {
        String sql = "select u from Users u where u.username = :userId and u.password = :password";
        EntityManager em = JpaUtils.getEntityManager();
        TypedQuery<Users> query = em.createQuery(sql, Users.class);
        query.setParameter("userId", userID);
        query.setParameter("password", password);
        return query.getResultList();
    }

    public Users login(String username, String pwd) {
        String hql = "select u from Users u where u.username = :username and u.password = :password";
        EntityManager em = JpaUtils.getEntityManager();
        TypedQuery<Users> query = em.createQuery(hql, Users.class);
        query.setParameter("username", username);
        query.setParameter("password", pwd);
        List<Users> results = query.getResultList();
        for (Users user : results) {
            if (EncryptUtils.checkPass(pwd, user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    public Users checkAccount(String users) {
        String sql = "select  * from users where username = ?";
        try {
            Connection con = BaseService.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, users);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return (new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getBoolean(8), rs.getString(9), rs.getDate(10), rs.getBoolean(11), rs.getBoolean(12)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Users findByUsername(String username) {
        EntityManager em = JpaUtils.getEntityManager();
        String jpql = "SELECT obj FROM Users obj WHERE obj.username = :username";
        TypedQuery<Users> query = em.createQuery(jpql, Users.class);
        query.setParameter("username", username);
        return query.getSingleResult();
    }
}
