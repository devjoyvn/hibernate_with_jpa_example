import com.sun.org.apache.xpath.internal.operations.Or;
import entities.Order;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Refresh {
    public static void main(String[] agrs) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("cascade");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        User user = new User();
        user.setName("NAME A");
        Order order = new Order();
        order.setDate(LocalDate.of(2020, 1, 1));
        order.setUser(user);
        user.getOrders().add(order);
        em.persist(user);
        em.persist(order);
        em.flush();

        user.setName("NAME B");
        order.setDate(LocalDate.of(2020, 2, 1));
        System.out.println(user.getName());
        System.out.println(order.getDate());
        em.refresh(user);
        System.out.println(user.getName());
        System.out.println(order.getDate());
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
