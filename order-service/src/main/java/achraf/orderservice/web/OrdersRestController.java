package achraf.orderservice.web;

import achraf.orderservice.clients.InventoryRestClient;
import achraf.orderservice.entities.Order;
import achraf.orderservice.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class OrdersRestController {
    private OrderRepository orderRepository;
    private InventoryRestClient inventoryRestClient;

    @GetMapping("/orders")
    public List<Order> findAllOrders(){
        List<Order> allOrders = orderRepository.findAll();
        allOrders.forEach(o->{
            o.getProductItems().forEach(pi->{
                //pi.setProduct(inventoryRestClient.findProductById(pi.getProductId()));
            });
        });
        return allOrders;
    }
    @GetMapping("/orders/{id}")
    public Order findOrderById(@PathVariable String id){
        Order order = orderRepository.findById(id).get();
        order.getProductItems().forEach(pi->{
            //pi.setProduct(inventoryRestClient.findProductById(pi.getProductId()));
        });
        return order;
    }

}
