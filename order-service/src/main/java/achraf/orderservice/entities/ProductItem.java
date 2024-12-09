package achraf.orderservice.entities;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor @AllArgsConstructor @Data @ToString @Builder
public class ProductItem {
    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String productId;
    private double price;
    private int quantity;
    @ManyToOne
    private Order order;
}
