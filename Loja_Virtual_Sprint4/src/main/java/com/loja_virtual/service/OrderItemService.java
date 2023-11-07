package com.loja_virtual.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja_virtual.Request.OrderItemRequest;
import com.loja_virtual.model.OrderItem;
import com.loja_virtual.model.Product;
import com.loja_virtual.repository.OrderItemRepository;
import com.loja_virtual.repository.ProductRepository;

// TODO André Gomes: Os serviçoes não devem enviar as entidades mas sim DTOs. Por exemplo, ver ModelMapper (https://www.baeldung.com/java-modelmapper)

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private ProductRepository productService; // TODO: Mudar o nome para repository 
    
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public OrderItem updateOrderItem(OrderItemRequest updatedOrderItem) {
           OrderItem orderItem = new OrderItem();
           Long id = updatedOrderItem.getProduct();
           Product product = productService.findById(id).orElse(null);
            if(product != null) {
            	orderItem.setProduct(product);
                orderItem.setQuantity(updatedOrderItem.getQuantity());
                orderItem.setUnitPrice(updatedOrderItem.getUnitPrice());
                orderItem.setTotalPrice(updatedOrderItem.getTotalPrice());
                return orderItemRepository.save(orderItem);
            }
            // TODO André Gomes atenção aos nulls, no Controller estamos a validar?
            return null;
    }

    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }
}