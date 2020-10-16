import entities.Order;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Detached {
    public static void main(String[] agrs) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("cascade");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, 1L);
        Order order = user.getOrders().iterator().next();

        System.out.println("Before deteach");
        System.out.println("User belong to Persistence context: " + em.contains(user));
        System.out.println("User belong to Persistence context: " + em.contains(order));

        em.detach(user);
        System.out.println("After deteach");

        System.out.println("User belong to Persistence context: " + em.contains(user));
        System.out.println("User belong to Persistence context: " + em.contains(order));
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
