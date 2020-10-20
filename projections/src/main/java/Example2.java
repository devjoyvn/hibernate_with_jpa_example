import entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Example2 {

    public static void main(String[] agrs) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("projections");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
//Query query = entityManager.createQuery("select id, name, unitPrice from Product");
//List<Object[]> resultList = query.getResultList();
//for(Object[] item : resultList) {
//    System.out.println(item[0]);
//    System.out.println(item[1]);
//    System.out.println(item[2]);
//}

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root<Product> product = query.from(Product.class);
        query.multiselect(product.get("id"), product.get("name"), product.get("unitPrice"));
        List<Object[]> resultList = entityManager.createQuery(query).getResultList();
        for (Object[] item : resultList) {
            System.out.println(item[0]);
            System.out.println(item[1]);
            System.out.println(item[2]);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        emf.close();
    }
}
