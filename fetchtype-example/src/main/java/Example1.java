import entities.Item;
import entities.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Set;

public class Example1 {
    public static void main(String[] agrs) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("fetchtype");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Order order = em.find(Order.class, 1L);
        Set<Item> items = order.getItems();
        System.out.println(items.size());
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
