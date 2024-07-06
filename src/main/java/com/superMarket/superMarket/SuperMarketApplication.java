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
public class SuperMarketApplication {
	

	@Autowired
	ProductService productService;

	@Autowired
	ProductCategoryService productCategoryService;

	@Autowired
	OrdersService ordersService;


	public static void main(String[] args) {
		SpringApplication.run(SuperMarketApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
////		createProductCategory();
////		createProduct();
//	}
//
//	private void createProduct() throws IOException {
//		ReadFromFile.read(importFile).forEach(importedProduct ->
//				productService.createProduct(importedProduct.getName(),
//						importedProduct.getDescription(),
//						importedProduct.getPrice(),
//						importedProduct.getCategory(),
//						importedProduct.getQuantity(),importedProduct.getImage(),
//						importedProduct.isOnDiscount,importedProduct.getNewPrice()));
//	}
//
//	private void createProductCategory() {
//		productCategoryService.create("BV","Beverages","Beverages category includes a wide variety of drinks, juices, and other refreshing beverages. From energizing coffee blends to healthy fruit juices and soft drinks, this category caters to diverse tastes and preferences.","https://i.pinimg.com/originals/3f/ef/cb/3fefcb509e1839f5a6235bcc668b711a.jpg");
//		productCategoryService.create("SN","Snacks","Snacks category offers a delicious array of chips, cookies, and other savory and sweet treats. Perfect for satisfying cravings between meals or enjoying as a quick snack on the go.","https://i.pinimg.com/originals/66/ac/43/66ac431b2dded792837e0fba60e2240b.jpg");
//		productCategoryService.create("VG","Vegetables","Vegetables category features a variety of fresh and nutritious produce, sourced to bring you the best in flavor and quality. From leafy greens to vibrant root vegetables, our selection caters to your culinary needs.","https://i.pinimg.com/originals/93/06/03/9306037b0fdcac44cefbdb4ecd3c91ff.jpg");
//		productCategoryService.create("FR","Fruits","Fruits category offers a vibrant selection of fresh and juicy fruits, packed with vitamins and natural goodness. From seasonal favorites to exotic varieties, our fruits are a delicious addition to any diet.","https://i.pinimg.com/originals/33/13/c1/3313c1b779276d0cb6137f02ac586a9c.jpg");
//	}
//
//	private static class ReadFromFile
//	{
//		private String name,description,category,image;
//
//		private Double price,newPrice;
//
//		private int quantity;
//		private boolean isOnDiscount;
//
//		public static List<ReadFromFile> read(String importFile) throws IOException {
//			return new ObjectMapper().setVisibility(FIELD, ANY).
//					readValue(new FileInputStream(importFile), new TypeReference<List<ReadFromFile>>() {
//					});
//		}
//		public String getName() {
//			return name;
//		}
//
//		public String getDescription() {
//			return description;
//		}
//
//		public Double getPrice() {
//			return price;
//		}
//
//		public String getCategory() {
//			return category;
//		}
//		public String getImage() {
//			return image;
//		}
//
//		public int getQuantity() {
//			return quantity;
//		}
//
//		public boolean isOnDiscount(){
//
//			return isOnDiscount;
//		}
//		public double getNewPrice(){
//			return newPrice;
//		}
//	}
}
