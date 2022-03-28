package DAO;

import Service.BaseService;
import Utils.JpaUtils;
import entity.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DAO<Users, Integer> {

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
    public void delete(Integer key) {
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
        } finally {
            em.close();
        }
    }

    @Override
    public List<Users> findAll() {
        EntityManager em = JpaUtils.getEntityManager();
        TypedQuery<Users> query = em.createQuery("select u from Users u order by u.id desc ", Users.class);
        return query.getResultList();
    }

    @Override
    public Users findByID(Integer key) {
        EntityManager em = JpaUtils.getEntityManager();
        return em.find(Users.class, key);
    }

    public List<Users> findKeyword(String key) {
        String sql = "select u from Users u where u.fullName like:key";
        EntityManager entityManager = JpaUtils.getEntityManager();
        TypedQuery<Users> query = entityManager.createQuery(sql, Users.class);
        query.setParameter("key", "%" + key + "%");
        return query.getResultList();
    }

    public List<Users> orId() {
        EntityManager em = JpaUtils.getEntityManager();
        TypedQuery<Users> query = em.createQuery("select u from Users u order by u.id asc ", Users.class);
        return query.getResultList();
    }

    public int getTotalAccount() {
        String sql = "select count(*) from users";
        try {
            Connection con = BaseService.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
//                int countPage = total/3;
//                if(total % 5 != 0){
//                    countPage++;
//                }
//                return countPage;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Users> pagingAccount(int index) {
        List<Users> list = new ArrayList<>();
        String sql = "select  * from users limit ?,3";
        try {
            Connection con = BaseService.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 3);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Users(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
                        ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        int innn = dao.getTotalAccount();
        System.out.println(innn);

    }
}
