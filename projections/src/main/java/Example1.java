import entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Example1 {
    public static void main(String[] agrs) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("projections");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
//        Query query = entityManager.createQuery("select name from Product");
//        List<Object> resultList = query.getResultList();
//        System.out.println(resultList);

CriteriaBuilder builder = entityManager.getCriteriaBuilder();
CriteriaQuery<String> query = builder.createQuery(String.class);
Root<Product> product = query.from(Product.class);
query.select(product.<String>get("name"));
List<String> resultList = entityManager.createQuery(query).getResultList();
System.out.println(resultList);

        entityManager.getTransaction().commit();
        entityManager.close();
        emf.close();
    }
}
