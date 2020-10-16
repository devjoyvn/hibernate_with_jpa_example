import entities.Order;
import entities.User;
import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.ReplicationMode;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Lock {

    public static void main(String[] agrs) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("cascade");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        User user = new User();
        Order order = new Order();
        order.setUser(user);
        user.getOrders().add(order);
        em.persist(user);
        em.persist(order);
        em.flush();
        System.out.println("Before lock");
        System.out.println("User belong to Persistence context: " + em.contains(user));
        System.out.println("User belong to Persistence context: " + em.contains(order));

        em.detach(user);
        em.detach(order);

        em.unwrap(Session.class)
                .buildLockRequest(new LockOptions(LockMode.NONE))
                .lock(user);

        System.out.println("After lock");
        System.out.println("User belong to Persistence context: " + em.contains(user));
        System.out.println("User belong to Persistence context: " + em.contains(order));

        em.close();
        emf.close();
    }
}
