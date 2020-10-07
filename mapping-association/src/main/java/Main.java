
import entities.Item;
import entities.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] agrs) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("mappingAssociation");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        OrderItem orderItem = new OrderItem();
        em.persist(orderItem);
        Item item = new Item(orderItem);
        em.persist(item);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
