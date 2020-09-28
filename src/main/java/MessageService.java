import entities.Message;
import entities.Message2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MessageService {

    public void test () {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("HelloWorldPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Message message = new Message(); // 2
        message.setText("Hello World!");
        message.setId(1l);
        em.merge(message);


        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
