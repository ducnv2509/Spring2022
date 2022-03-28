package DAO;

import Utils.JpaUtils;
import enititySQLServer.Users;
//import entityMySQL.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class UserDAO extends DAO<Users, String> {
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
    public void delete(String key) {

    }

    @Override
    public List<Users> findAll() {
        return null;
    }

    @Override
    public Users findByID(String key) {
        return null;
    }
}
