package com.loja_virtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loja_virtual.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
}