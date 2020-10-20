package entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Product {
    @Id
    private long id;

    private String name;

    private String description;

    private String category;

    private BigDecimal unitPrice;

}