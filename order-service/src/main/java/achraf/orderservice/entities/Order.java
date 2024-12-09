package achraf.orderservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

import static jakarta.persistence.EnumType.STRING;

@Entity
@NoArgsConstructor @AllArgsConstructor @Data @Builder @ToString
public class Order {
    @Id
    private String id;
    private LocalDate date;
    @Enumerated(STRING)
    private OrderState state;
    @OneToMany(mappedBy = "order")
    private List<ProductItem> productItems;
}
