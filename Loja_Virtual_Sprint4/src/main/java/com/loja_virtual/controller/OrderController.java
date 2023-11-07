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

import com.loja_virtual.Request.OrderRequest;
import com.loja_virtual.model.Order;
import com.loja_virtual.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //listar todos os pedidos
    @GetMapping("/list")
    public List<Order> listOrders() {
        return orderService.getAllOrders();
    }

    // atualizar um pedido por ID
    @PostMapping("/add")
    public Order updateOrder(@RequestBody OrderRequest order) {
        return orderService.addOrder(order);
    }

    // excluir um pedido por ID
    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}
