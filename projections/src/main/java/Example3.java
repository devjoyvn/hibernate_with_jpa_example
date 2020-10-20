import entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Example3 {
    public static void main(String[] agrs) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("projections");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
//Query query = entityManager.createQuery("select p.category, count(p) from Product p group by p.category");
//List<Object[]> resultList = query.getResultList();
//for(Object[] item : resultList) {
//    System.out.println(item[0] + " " + item[1]);
//}

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root<Product> product = query.from(Product.class);
        query.multiselect(product.get("category"), builder.count(product));
        query.groupBy(product.get("category"));
        List<Object[]> resultList = entityManager.createQuery(query).getResultList();
        for (Object[] item : resultList) {
            System.out.println(item[0] + " " + item[1]);
        }


        entityManager.getTransaction().commit();
        entityManager.close();
        emf.close();
    }
}
