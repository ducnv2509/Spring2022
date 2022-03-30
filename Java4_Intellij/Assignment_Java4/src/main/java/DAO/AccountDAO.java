package DAO;

import Utils.BaseService;
import Utils.JpaUtils;
import entity.Products;
import entity.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    }

    @Override
    public void delete(Integer key) throws Exception {

    }

    @Override
    public List<Users> findAll() {
        return null;
    }

    @Override
    public Users findByID(Integer key) {
        return null;
    }

    public Users login(String users, String pass) {
        String sql = "select  * from users where username = ? and password = ?";
        try {
            Connection con = BaseService.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, users);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return (new Users(
                        rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getBoolean(8),
                        rs.getString(9), rs.getDate(10), rs.getBoolean(11), rs.getBoolean(12)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
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
                return (new Users(
                        rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getBoolean(8),
                        rs.getString(9), rs.getDate(10), rs.getBoolean(11), rs.getBoolean(12)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
