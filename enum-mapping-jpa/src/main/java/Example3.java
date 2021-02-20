import entities.Article;
import entities.Priority;
import entities.Status;
import entities.Type;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Example3 {

    public static void main(String... args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("enum-mapping");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        Article article = new Article();
        article.setId(1);
        article.setTitle("entity event title");
        article.setStatus(Status.OPEN);
        article.setType(Type.EXTERNAL);
        article.setPriority(Priority.HIGH);

        entityManager.persist(article);

        entityManager.getTransaction().commit();
        entityManager.close();
        emf.close();
    }
}
