package com.alayon.product;

import com.alayon.product.entities.Product;
import com.alayon.product.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductsDataApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	@Order(1)
	public void testCreate(){
		Product product = new Product();
		product.setId(1);
		product.setName("Iphone");
		product.setDescription("Awesome");
		product.setPrice(1000d);

		productRepository.save(product);

		Assertions.assertThat(productRepository.count()).isEqualTo(1);
	}

	@Test
	@Order(2)
	public void testRead(){
		Product product = productRepository.findById(1).get();
		Assertions.assertThat(product).isNotNull();
		Assertions.assertThat(product.getName()).isEqualTo("Iphone");
	}

	@Test
	@Order(3)
	public void testUpdate(){
		final Product product = productRepository.findById(1).get();
		product.setPrice(15000d);
		Product productSaved = productRepository.save(product);

		Assertions.assertThat(productSaved.getPrice()).isEqualTo(15000d);
	}

	@Test
	@Order(4)
	public void testDelete(){
		productRepository.deleteById(1);
		Assertions.assertThat(productRepository.existsById(1)).isFalse();
	}
}
