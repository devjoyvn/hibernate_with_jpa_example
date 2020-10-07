package entities;

import javax.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_order")
    private OrderItem orderItem;

    public Item(OrderItem orderItem) {
        this.orderItem = orderItem;
    }
}
