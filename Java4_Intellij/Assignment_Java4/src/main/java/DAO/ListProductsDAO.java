package DAO;

import Utils.BaseService;
import Utils.JpaUtils;
import entity.Category;
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
import java.util.Properties;

public class ListProductsDAO extends DAO<Products, Integer> {

    @Override
    public void insert(Products entity) {
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
    public void update(Products entity) {
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
            Products user = em.find(Products.class, key);
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
    public List<Products> findAll() {
        String sql = "select u from Products u order by u.id desc";
        EntityManager em = JpaUtils.getEntityManager();
        TypedQuery<Products> query = em.createQuery(sql, Products.class);
        return query.getResultList();
    }

    @Override
    public Products findByID(Integer key) {
        EntityManager em = JpaUtils.getEntityManager();
        return em.find(Products.class, key);
    }

    public int getTotalProducts() {
        String sql = "select count(*) from products";
        try {
            Connection con = BaseService.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Products> pagingAccount(int index) {
        List<Products> list = new ArrayList<>();
        String sql = "select  * from products order by id offset  ? rows  fetch next 6 rows  only";
        try {
            Connection con = BaseService.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 3);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Products(
                        rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
                        rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getString(11), rs.getDate(12), rs.getDate(13)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public List<Products> getProductByCategory(int id) {
        String sql = "select u from Products u where u.id =:id";
        EntityManager em = JpaUtils.getEntityManager();
        TypedQuery<Products> query = em.createQuery(sql, Products.class);
        return query.getResultList();
    }

    public List<Products> getProductByIdCategory(int index) {
        List<Products> list = new ArrayList<>();
        String sql = "select * from products where category_id = ?";
        try {
            Connection con = BaseService.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, index);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Products(
                        rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
                        rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getString(11), rs.getDate(12), rs.getDate(13)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Products getProductByID(int index) {
        String sql = "select * from products where id = ?";
        try {
            Connection con = BaseService.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, index);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return (new Products(
                        rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
                        rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getString(11), rs.getDate(12), rs.getDate(13)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Products> searchProductByName(String search) {
        List<Products> list = new ArrayList<>();
        String sql = "select  * from products where nameProduct like ?";
        try {
            Connection con = BaseService.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + search + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Products(
                        rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
                        rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getString(11), rs.getDate(12), rs.getDate(13)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
