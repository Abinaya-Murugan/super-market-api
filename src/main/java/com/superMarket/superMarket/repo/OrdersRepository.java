package com.superMarket.superMarket.repo;

import com.superMarket.superMarket.domain.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Orders,Integer> {
}
