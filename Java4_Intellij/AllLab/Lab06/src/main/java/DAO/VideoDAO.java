package DAO;

import Utils.JpaUtils;
import enitity.Videos;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class VideoDAO extends DAOM<Videos, String> {
    @Override
    public void insert(Videos entity) {

    }

    @Override
    public void update(Videos entity) {

    }

    @Override
    public void delete(String key) {

    }

    @Override
    public List<Videos> findAll() {
        return null;
    }

    @Override
    public Videos findByID(String key) {
        return null;
    }

    public List<Videos> findFavoriteVideosUserID(String id) {
        EntityManager em = JpaUtils.getEntityManager();
        String sql = "select f.video from  Favorites f where f.user.id = :userID";
        TypedQuery<Videos> query = em.createQuery(sql, Videos.class);
        query.setParameter("userID", id);
        return query.getResultList();
    }
}
