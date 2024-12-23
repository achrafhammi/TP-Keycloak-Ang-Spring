package achraf.inventoryservice;

import achraf.inventoryservice.entities.Product;
import achraf.inventoryservice.repos.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository){
		return args -> {
			productRepository.save(Product.builder().id(UUID.randomUUID().toString()).name("Computer").price(2300).quantity(12).build());
			productRepository.save(Product.builder().id(UUID.randomUUID().toString()).name("Printer").price(1200).quantity(10).build());
			productRepository.save(Product.builder().id(UUID.randomUUID().toString()).name("Smart Phone").price(4200).quantity(32).build());
		};
	}
}
