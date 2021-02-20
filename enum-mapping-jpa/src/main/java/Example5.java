import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Example5 {

    public static void main(String... args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("enum-mapping");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
//
//String jpql = "select a from Article a where a.category = entities.Category.MUSIC";
//
//List<Article> articles = entityManager.createQuery(jpql, Article.class)
//        .getResultList();
//
//System.out.println(articles);

String jpql = "select a from Article a where a.category = :category";

TypedQuery<Article> query = entityManager.createQuery(jpql, Article.class);
query.setParameter("category", Category.MUSIC);

List<Article> articles = query.getResultList();

        System.out.println(articles);
        entityManager.getTransaction().commit();
        entityManager.close();
        emf.close();
    }
}
