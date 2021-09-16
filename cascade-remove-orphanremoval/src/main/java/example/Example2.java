package example;

import entity.LineItem;
import entity.OrderRequest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.List;

public class Example2 {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("removal");

    public static void main(String[] args) {
        createOrderRequestWithLineItems();

        EntityManager em = emf.createEntityManager();

        OrderRequest orderRequest = em.find(OrderRequest.class, 1L);
        List<LineItem> lineItems = orderRequest.getLineItems();
        LineItem lineItem = lineItems.get(0);
        LineItem lineItem1 = lineItems.get(1);
        LineItem lineItem2 = lineItems.get(2);
        System.out.println("LineItem 1: " + lineItem.getName());
        System.out.println("LineItem 2: " + lineItem1.getName());
        System.out.println("LineItem 3: " + lineItem2.getName());
        orderRequest.removeLineItem(lineItem1);

        em.getTransaction().begin();
        em.merge(orderRequest);
        em.getTransaction().commit();

        OrderRequest orderRequestAfterDeleteLineItem = em.find(OrderRequest.class, 1L);
        List<LineItem> list = orderRequestAfterDeleteLineItem.getLineItems();
        System.out.println("LineItem after remove: " + list.size());
    }

    private static void createOrderRequestWithLineItems() {
        EntityManager em = emf.createEntityManager();

        List<LineItem> lineItems = new ArrayList<>();
        lineItems.add(new LineItem("line item 1"));
        lineItems.add(new LineItem("line item 2"));
        lineItems.add(new LineItem("line item 3"));

        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setLineItems(lineItems);
        lineItems.forEach(lineItem -> lineItem.setOrderRequest(orderRequest));

        em.getTransaction().begin();
        em.persist(orderRequest);
        em.flush();
        em.getTransaction().commit();
    }

    private static List<OrderRequest> findAllOrderRequest() {
        EntityManager em = emf.createEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<OrderRequest> cq = cb.createQuery(OrderRequest.class);
        Root<OrderRequest> root = cq.from(OrderRequest.class);
        CriteriaQuery<OrderRequest> findAll = cq.select(root);
        TypedQuery<OrderRequest> findAllQuery = em.createQuery(findAll);

        return findAllQuery.getResultList();
    }

}
