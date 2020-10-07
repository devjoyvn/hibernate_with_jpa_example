package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(mappedBy = "orderItem")
    private Set<Item> items = new HashSet<>();
}
