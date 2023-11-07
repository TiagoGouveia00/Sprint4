package com.loja_virtual.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja_virtual.model.Client;
import com.loja_virtual.repository.ClientRepository;

// TODO André Gomes: Os serviçoes não devem enviar as entidades mas sim DTOs. Por exemplo, ver ModelMapper (https://www.baeldung.com/java-modelmapper)

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}
	
	public Client findById(long id) {
		return clientRepository.findById(id).orElse(null);
	}	

		
	public Client addClient(Client client) {
		return clientRepository.save(client);
	}

}
