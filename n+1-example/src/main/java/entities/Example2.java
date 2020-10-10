package entities;

import org.hibernate.jpa.QueryHints;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.QueryHint;
import java.util.List;

public class Example2 {

    public static void main(String[] agrs) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("n_1_problem");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // NORMAL  SCRIPT
//        List<PostComment> postComments = em.createQuery("select p from PostComment p").getResultList();

        // JOIN FETCH SCRIPT
//        List<PostComment> postComments = em.createQuery("select pc from PostComment pc join fetch pc.post").getResultList();



        // HINT_CACHEABLE SCRIPT
        List<PostComment> postComments = em.createQuery("select pc from PostComment pc")
                .setMaxResults(4)
                .setHint(QueryHints.HINT_CACHEABLE, true)
                .getResultList();



//        for(PostComment postComment : postComments) {
//            System.out.println(postComment.getPost().getTitle());
//        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
