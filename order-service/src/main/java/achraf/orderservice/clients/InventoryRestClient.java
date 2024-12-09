package achraf.orderservice.clients;

import achraf.orderservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url= "http://localhost:8087")
public interface InventoryRestClient {
    @GetMapping("/api/products")
    List<Product> getAllProducts();
}
