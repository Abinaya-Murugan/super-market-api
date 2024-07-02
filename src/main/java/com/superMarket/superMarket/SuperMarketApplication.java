package com.superMarket.superMarket;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.superMarket.superMarket.service.OrdersService;
import com.superMarket.superMarket.service.ProductCategoryService;
import com.superMarket.superMarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;

@SpringBootApplication
public class SuperMarketApplication implements CommandLineRunner {

	@Value("${superMarket.importfile}")
	private String importFile;

	@Autowired
	ProductService productService;

	@Autowired
	ProductCategoryService productCategoryService;

	@Autowired
	OrdersService ordersService;


	public static void main(String[] args) {
		SpringApplication.run(SuperMarketApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createProductCategory();
		createProduct();
	}

	private void createProduct() throws IOException {
		ReadFromFile.read(importFile).forEach(importedProduct ->
				productService.createProduct(importedProduct.getName(),
						importedProduct.getDescription(),
						importedProduct.getPrice(),
						importedProduct.getCategory(),
						importedProduct.getQuantity()));
	}

	private void createProductCategory() {
		productCategoryService.create("BV","Beverages","Drinks, juices, and other beverages");
		productCategoryService.create("SN","Snacks","Chips, cookies, and other snacks");
		productCategoryService.create("VG","Vegetables","Fresh Vegetables");
		productCategoryService.create("FR","Fruits","Fresh Fruits");
	}

	private static class ReadFromFile
	{
		private String name,description,category;

		private Double price;

		private int quantity;

		public static List<ReadFromFile> read(String importFile) throws IOException {
			return new ObjectMapper().setVisibility(FIELD, ANY).
					readValue(new FileInputStream(importFile), new TypeReference<List<ReadFromFile>>() {
					});
		}
		public String getName() {
			return name;
		}

		public String getDescription() {
			return description;
		}

		public Double getPrice() {
			return price;
		}

		public String getCategory() {
			return category;
		}

		public int getQuantity() {
			return quantity;
		}
	}
}
