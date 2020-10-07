package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToMany
    @JoinTable(name = "store_product",
            joinColumns = { @JoinColumn(name = "fk_store") },
            inverseJoinColumns = { @JoinColumn(name = "fk_product") })
    private Set<Product> products = new HashSet<>();
}
