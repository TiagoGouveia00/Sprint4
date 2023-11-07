package com.loja_virtual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.loja_virtual.service.ClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja_virtual.model.Client;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value ="/client", consumes = "application/json")
public class ClientController {
	@Autowired
	private ClientService clientService;

    @GetMapping("/list")
    public List<Client> listarclient() {
        return clientService.getAllClients();
    }
    
    @PostMapping("/add")
    public Client addProduct(@RequestBody @Valid Client client) {
		return clientService.addClient(client);
	}
}


