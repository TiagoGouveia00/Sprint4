package com.loja_virtual.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja_virtual.Request.OrderRequest;
import com.loja_virtual.model.Order;
import com.loja_virtual.model.OrderItem;
import com.loja_virtual.repository.ClientRepository;
import com.loja_virtual.repository.OrderItemRepository;
import com.loja_virtual.repository.OrderRepository;

//TODO André Gomes: Os serviçoes não devem enviar as entidades mas sim DTOs. Por exemplo, ver ModelMapper (https://www.baeldung.com/java-modelmapper)

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ClientRepository clientService;
    @Autowired
    private OrderItemRepository orderItemRepository; 
    
    
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order addOrder(OrderRequest orderRequest) {
       
    		Order order = new Order();
    		com.loja_virtual.model.Client client = clientService.findById(orderRequest.getClient()).orElse(null);
            order.setNumber(orderRequest.getNumber());
            order.setCreationDate(LocalDate.now());
            order.setClient(client);
            // TODO Não conseguimos utilizar os streams do Java 8?
            for(int i=0;i<orderRequest.getOrderitems().size();i++) {
            	OrderItem orderItem = orderItemRepository.findById(orderRequest.getOrderitems().get(i)).orElse(null);
            	orderItem.setOrder(order);
            }
            return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
