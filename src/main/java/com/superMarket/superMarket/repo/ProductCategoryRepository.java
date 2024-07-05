package com.superMarket.superMarket.repo;

import com.superMarket.superMarket.domain.Product;
import com.superMarket.superMarket.domain.ProductCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory,String> {
}
