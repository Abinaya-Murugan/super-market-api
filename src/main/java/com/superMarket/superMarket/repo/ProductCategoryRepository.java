package com.superMarket.superMarket.repo;

import com.superMarket.superMarket.domain.ProductCategory;
import org.springframework.data.repository.CrudRepository;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory,String> {
}
