package DAO;

import Utils.JpaUtils;
import entity.Supplier;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class SupplierDAO extends DAO<Supplier, Integer> {

    @Override
    public void insert(Supplier entity) {

    }

    @Override
    public void update(Supplier entity) {

    }

    @Override
    public void delete(Integer key) throws Exception {

    }

    @Override
    public List<Supplier> findAll() {
        String sql = "select u from Supplier u";
        EntityManager em = JpaUtils.getEntityManager();
        TypedQuery<Supplier> query = em.createQuery(sql, Supplier.class);
        return query.getResultList();
    }

    @Override
    public Supplier findByID(Integer key) {
        return null;
    }
}
