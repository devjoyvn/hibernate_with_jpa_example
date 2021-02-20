import entities.Article;
import entities.Status;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Example1 {

    public static void main(String... args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("enum-mapping");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        Article article = new Article();
        article.setId(1);
        article.setTitle("ordinal title");
        article.setStatus(Status.OPEN);

        entityManager.persist(article);

        entityManager.getTransaction().commit();
        entityManager.close();
        emf.close();
    }
}
