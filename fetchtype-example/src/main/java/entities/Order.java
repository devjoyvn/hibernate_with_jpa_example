package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PurchaseOrder")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private Set<Item> items = new HashSet<Item>();

    public Set<Item> getItems() {
        return items;
    }
}
