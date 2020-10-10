package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Example1 {

    public static void main(String[] agrs) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("n_1_problem");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // NORMAL SCRIPT
//        List<Post> posts = em.createQuery("select p from Post p").getResultList();

        // JOIN FETCH SCRIPT
        List<Post> posts = em.createQuery("select p from Post p join fetch p.postComments pc").getResultList();

        for (Post post : posts) {
            System.out.println("Post Comments: " + post.getPostComments().size());
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}
