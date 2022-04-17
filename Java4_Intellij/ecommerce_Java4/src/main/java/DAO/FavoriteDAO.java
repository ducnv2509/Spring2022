package DAO;

import Utils.JpaUtils;
import entity.Favorite;
import entity.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class FavoriteDAO extends DAO<Favorite, Integer> {
    @Override
    public void insert(Favorite entity) {
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
    public void update(Favorite entity) {

    }

    @Override
    public void delete(Integer key) throws Exception {

    }

    @Override
    public List<Favorite> findAll() {
        String sql = "select u from Favorite u order by u.id desc";
        EntityManager em = JpaUtils.getEntityManager();
        TypedQuery<Favorite> query = em.createQuery(sql, Favorite.class);
        return query.getResultList();
    }

    @Override
    public Favorite findByID(Integer key) {
        EntityManager em = JpaUtils.getEntityManager();
        return em.find(Favorite.class, key);
    }

    public List<Favorite> findByIDUser(Integer key) {
        String sql = "select u from Favorite u where u.userId =: key";
        EntityManager em = JpaUtils.getEntityManager();
        TypedQuery<Favorite> query = em.createQuery(sql, Favorite.class);
        query.setParameter("key", key);
        return query.getResultList();
    }
}
