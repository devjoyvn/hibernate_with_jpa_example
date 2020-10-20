package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Example2 {
    public static void main(String[] agrs) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("compositekey");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
BookId bookId = new BookId("BOOK_OO1", "VN");
        Book book = new Book(bookId, "shareprogramming.net");
        em.persist(book);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
