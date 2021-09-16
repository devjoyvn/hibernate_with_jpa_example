package example;

import entity.OrderRequest;
import entity.ShipmentInfo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Example1 {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("removal");

    public static void main(String[] args) {

        // init data
        createOrderRequestWithShipmentInfo();

        EntityManager em = emf.createEntityManager();
        OrderRequest orderRequest = em.find(OrderRequest.class, 1L);
        ShipmentInfo shipmentInfo = orderRequest.getShipmentInfo();
        System.out.println("ShipmentInfo Name: " + shipmentInfo.getName());

        // remove cascade
        em.getTransaction().begin();
        em.remove(orderRequest);
        em.getTransaction().commit();

        List<OrderRequest> orderRequests = findAllOrderRequest();
        System.out.println("OrderRequests size: " + orderRequests.size());

        List<ShipmentInfo> shipmentInfos = findAllShipmentInfo();
        System.out.println("ShipmentInfo size: " + shipmentInfos.size());
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

    private static List<ShipmentInfo> findAllShipmentInfo() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ShipmentInfo> cq = cb.createQuery(ShipmentInfo.class);
        Root<ShipmentInfo> root = cq.from(ShipmentInfo.class);
        CriteriaQuery<ShipmentInfo> findAll = cq.select(root);
        TypedQuery<ShipmentInfo> findAllQuery = em.createQuery(findAll);

        return findAllQuery.getResultList();
    }


    private static void createOrderRequestWithShipmentInfo() {
        EntityManager em = emf.createEntityManager();
        ShipmentInfo shipmentInfo = new ShipmentInfo();
        shipmentInfo.setName("name");
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setShipmentInfo(shipmentInfo);

        em.getTransaction().begin();
        em.persist(orderRequest);
        em.getTransaction().commit();

    }
}
