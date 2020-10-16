import entities.Order;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class PersistAndMerge {
    public static void main(String[] agrs) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("cascade");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();


        Long userId;
         User user = new User();
        Order order = new Order();
        user.getOrders().add(order);
        order.setUser(user);

        // Lưu xuống database
        em.persist(user);
        em.persist(order);
        em.flush();

        // Cập nhật ID cho User và Order
        em.refresh(user);
        userId = user.getId();
        // Clear tất cả các persisent entity
        em.clear();

        User userSaved = em.find(User.class, userId);
        Order orderSaved = userSaved.getOrders().iterator().next();
        // merge entity và cascade
        userSaved.setName("Name updated");
        orderSaved.setDate(LocalDate.now().now());

        em.merge(userSaved);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
