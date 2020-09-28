
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import entities.*;

public class Main {

    public static void main(String[] agrs) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("helloword");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Message message = new Message();
        message.setText("Hello World!");
        em.persist(message);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
