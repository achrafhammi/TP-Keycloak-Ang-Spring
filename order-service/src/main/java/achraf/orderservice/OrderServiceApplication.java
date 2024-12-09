package achraf.orderservice;

import achraf.orderservice.clients.InventoryRestClient;
import achraf.orderservice.entities.Order;
import achraf.orderservice.entities.OrderState;
import achraf.orderservice.entities.ProductItem;
import achraf.orderservice.model.Product;
import achraf.orderservice.repository.OrderRepository;
import achraf.orderservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import static achraf.orderservice.entities.OrderState.*;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(
			OrderRepository orderRepository,
			ProductItemRepository productItemRepository,
			InventoryRestClient inventoryRestClient
	) {
		return args -> {
			List<Product> allProducts = inventoryRestClient.getAllProducts();
			List<String> productsIds = List.of("P01", "P02", "P03");
			for (int i = 0; i < 5; i++) {
				Order order = Order.builder()
						.id(UUID.randomUUID().toString())
						.date(LocalDate.now())
						.state(PENDING)
						.build();
				Order savedOrder = orderRepository.save(order);
				productsIds.forEach(pId -> {
					ProductItem productItem = ProductItem.builder()
							.productId(pId)
							.quantity(new Random().nextInt(20))
							.price(Math.random() * 6000 + 100)
							.order(savedOrder)
							.build();
					productItemRepository.save(productItem);
				});

			}
		};
	}
}
