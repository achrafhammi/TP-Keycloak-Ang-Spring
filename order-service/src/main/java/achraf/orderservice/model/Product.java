package achraf.orderservice.model;

import lombok.*;

@NoArgsConstructor @AllArgsConstructor @Data @ToString @Builder
public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;
}
