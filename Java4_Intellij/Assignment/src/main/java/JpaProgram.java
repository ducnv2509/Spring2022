import demo.User;
import entity.Category;
import entity.Demo;

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
            transaction.begin();
            User user = new User();
            user.setPassword("MNNAA");
            user.setUserId("1231");
            user.setFullname("Nguyen Van Duc");
            user.setAdmin(true);
            user.setEmail("ducnv12312@gmail.com");
            entityManager.persist(user);
            transaction.commit();
            System.out.println("OK");
        }catch(Exception e){
            System.out.println(e);
        }finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
