package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Utils.JpaUtils;
import model.Users;

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
		TypedQuery<Users> query = em.createQuery("select u from Users u", Users.class);
		return query.getResultList();
	}

	@Override
	public Users findByID(Integer key) {
		EntityManager em = JpaUtils.getEntityManager();
		return em.find(Users.class, key);
	}

}
