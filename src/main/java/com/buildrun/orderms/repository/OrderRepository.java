package com.buildrun.orderms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.buildrun.orderms.entity.OrderEntity;

public interface OrderRepository extends MongoRepository<OrderEntity, Long> {
    
    
}
