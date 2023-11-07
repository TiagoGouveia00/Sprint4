package com.loja_virtual.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.loja_virtual.model.Product;
import com.loja_virtual.repository.ProductRepository;

import lombok.AllArgsConstructor;

// TODO André Gomes: Os serviçoes não devem enviar as entidades mas sim DTOs. Por exemplo, ver ModelMapper (https://www.baeldung.com/java-modelmapper)

@AllArgsConstructor
@Service
public class ProductService {

	
	private ProductRepository productRepository;

	public List<Product> InitialData(List<Product> products) {

		List<Product> products1 = new ArrayList<>();

		// TODO ver ModelMapper
		for (Product x : products) {
			Product P = new Product((long) 0, x.getName(), x.getCode(), x.getPrice());
			products1.add(P);
		}
		return productRepository.saveAll(products1);
	}

	public List<Product> listarProdutos() {
		return productRepository.findAll();
	}
	
	public Product findById(long id) {
		return productRepository.findById(id).orElse(null);
	}

	public Product findByCode(String code) {
		return productRepository.findByCode(code);
	}

	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

}
