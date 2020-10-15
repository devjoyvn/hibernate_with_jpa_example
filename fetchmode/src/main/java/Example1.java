import entities.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Example1 {

    public static void main(String[] agrs) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("fetchmode");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        List<Customer> customers = em.createQuery("select c from Customer c").getResultList();
        for (Customer customer : customers) {
            System.out.println(customer.getOrders().size());
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
