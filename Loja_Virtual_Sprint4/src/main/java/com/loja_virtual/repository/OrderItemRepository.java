package com.loja_virtual.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loja_virtual.model.Order;
import com.loja_virtual.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
	List<OrderItem> findByOrder(Order order);

}
