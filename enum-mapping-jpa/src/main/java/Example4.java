import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Example4 {

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
        article.setCategory(Category.MUSIC);

        entityManager.persist(article);

        entityManager.getTransaction().commit();
        entityManager.close();
        emf.close();
    }
}
