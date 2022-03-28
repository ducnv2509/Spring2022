import DAO.demoDAO;
import entity.Category;
import entity.Demo;
import entity.OrderStates;
import entity.Orderdetails;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaProgram {
    public static void main(String[] args) {
        OrderStates demo = new OrderStates();
        demo.setNameStates("Huỷ");
        demoDAO dao = new demoDAO();
        dao.insert(demo);
        System.out.println("ok");
    }
//    public static void main(String[] args) {
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        EntityTransaction transaction = entityManager.getTransaction();
//        try {
//            transaction.begin();
//            Demo user = new Demo();
//            user.setNameM("AAAAAAAAAA");
//            entityManager.persist(user);
//            transaction.commit();
//            System.out.println("Ok");
//        } catch (Exception e) {
//            System.out.println(e);
//        } finally {
//            if (transaction.isActive()) {
//                transaction.rollback();
//            }
////            entityManager.close();
////            entityManagerFactory.close();
//        }
//    }
}
