package com.loja_virtual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja_virtual.Request.OrderItemRequest;
import com.loja_virtual.model.OrderItem;
import com.loja_virtual.service.OrderItemService;

@RestController
@RequestMapping("/orderItems")
public class OrderItemController {

	@Autowired
	private OrderItemService orderItemService;

	// listar todos os itens de pedidos
	@GetMapping("/list")
	public List<OrderItem> listOrderItems() {
		return orderItemService.getAllOrderItems();
	}

	// add um item de pedido por ID
	@PostMapping("/add")
	public OrderItem updateOrderItem(@RequestBody OrderItemRequest orderItemRequest) {
		return orderItemService.updateOrderItem(orderItemRequest);
	}

	// excluir um item de pedido por ID
	@DeleteMapping("/delete/{id}")
	public void deleteOrderItem(@PathVariable Long id) {
		orderItemService.deleteOrderItem(id);
	}
}