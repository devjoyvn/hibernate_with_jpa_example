package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Example1 {
    public static void main(String[] agrs) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("compositekey");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Account account = new Account("842582", "CREDIT", "ACB");
        em.persist(account);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
