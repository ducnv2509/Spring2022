import entity.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaProgram {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
//            transaction.begin();
//            Users user = new Users();
//            user.setPassword("Momx");
//            user.setAddress("Ha NOI");
//            user.setFullName("Nguyen Van Duc");
//            user.setAvatar("");
//            user.setEmail("ducnv12312@gmail.com");
//            user.setPhone("011113123");
//            entityManager.persist(user);
//            transaction.commit();
//            System.out.println("OK");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
