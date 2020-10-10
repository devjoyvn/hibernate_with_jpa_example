import entities.Gender;
import entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] agrs) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("entitySetup");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Student student = new Student("name", Gender.MALE);
        Student student1 = new Student("name", Gender.MALE);
        em.persist(student);
        em.persist(student1);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
