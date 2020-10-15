package entities;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer {
    @OneToMany(mappedBy = "customer")
//    @Fetch(value = FetchMode.SELECT)
//    @Fetch(value = FetchMode.JOIN)
//    @BatchSize(size=10)
    @Fetch(value = FetchMode.SUBSELECT)
    private Set<Order> orders = new HashSet<>();

    @Id
    @GeneratedValue
    private Long id;


    public Long getId() {
        return id;
    }

    public Set<Order> getOrders() {
        return orders;
    }
// getters and setters
}