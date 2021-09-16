package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class OrderRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
    private ShipmentInfo shipmentInfo;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.PERSIST, mappedBy = "orderRequest")
    private List<LineItem> lineItems;

    public void removeLineItem(LineItem lineItem) {
        lineItems.remove(lineItem);
    }
}