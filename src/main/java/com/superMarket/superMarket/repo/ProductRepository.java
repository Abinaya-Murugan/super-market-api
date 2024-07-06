package com.superMarket.superMarket.repo;

import com.superMarket.superMarket.domain.Product;
import com.superMarket.superMarket.domain.ProductCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product,Integer> {
    Optional<Product> findByName(String name);
    List<Product> findByCategoryId(ProductCategory productCategory);
}
