package entities;

import org.hibernate.ReplicationMode;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Replicate {
    public static void main(String[] agrs) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("cascade");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        User user = new User();
        user.setId(1L);
        user.setName("NAME A");

        Order order = new Order();
        order.setId(1L);

        order.setUser(user);
        user.getOrders().add(order);

        em.unwrap(Session.class).replicate(user, ReplicationMode.OVERWRITE);

        em.flush();
        em.close();
        emf.close();
    }
}
