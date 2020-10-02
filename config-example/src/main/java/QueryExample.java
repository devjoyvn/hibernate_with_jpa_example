import entities.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class QueryExample {

    public static void main(String[] agrs) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("helloword");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        List<Message> messages = em.createQuery("select m from Message m").getResultList();
        System.out.println("Size: " + messages.size());
        System.out.println("Text: " + messages.get(0).getText());
        messages.get(0).setText("Take me to your leader!");
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
