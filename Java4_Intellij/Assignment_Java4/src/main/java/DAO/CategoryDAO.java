package DAO;

import Utils.JpaUtils;
import entity.Category;
import entity.Products;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CategoryDAO extends DAO<Category, Integer>{
    @Override
    public void insert(Category entity) {

    }

    @Override
    public void update(Category entity) {

    }

    @Override
    public void delete(Integer key) throws Exception {

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
        return null;
    }
}
