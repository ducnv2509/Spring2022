package DAO;

import Utils.BaseService;
import Utils.JpaUtils;
import entity.Category;
import entity.Products;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class CategoryDAO extends DAO<Category, Integer> {
    @Override
    public void insert(Category entity) {
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
    public void update(Category entity) {
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
            Category category = em.find(Category.class, key);
            if (category != null) {
                em.remove(category);
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
    public List<Category> findAll() {
        String sql = "select u from Category u";
        EntityManager em = JpaUtils.getEntityManager();
        TypedQuery<Category> query = em.createQuery(sql, Category.class);
        return query.getResultList();
    }

    @Override
    public Category findByID(Integer key) {
        EntityManager em = JpaUtils.getEntityManager();
        return em.find(Category.class, key);
    }


    public int getQuantityByCategory(int index) {
        String sql = "select count(*) from products where category_id = ?";
        try {
            Connection con = BaseService.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, index);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        CategoryDAO c = new CategoryDAO();
        System.out.println( c.getQuantityByCategory(3));
    }
}
