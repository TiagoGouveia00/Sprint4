package com.loja_virtual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja_virtual.company.CompanyConfig;
import com.loja_virtual.model.Product;
import com.loja_virtual.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired // vai injetar uma instancia no repository
	private ProductService productService;	
	private final CompanyConfig companyConfig;
	

	//A anotação @RequestBody converte o corpo do pedido em objectos Product e @Valid é utilizada para validar os objectos com base em anotações de validação que podem estar nas classes Product.
	@PostMapping("/inic10")
	public List<Product> loadInitialData(@RequestBody @Valid List<Product> products) {
		return productService.InitialData(products);
	}

	// Serve para listar todos os produtos
	@GetMapping("/get")
	public List<Product> listar() {
		return productService.listarProdutos(); // devolve todas as instancias do tipo
	}

	// Serve para procurar um produto por código
	@GetMapping("/{code}")
	public Product getProductByCode(@PathVariable String code) {
		return productService.findByCode(code);
	}

	
	@GetMapping("/ola/{id}")
	public Product getProductByCode(@PathVariable long id) {
		return productService.findById(id);
	}
	
	// Serve para adicionar um novo produto
	@PostMapping("/add")
	public Product addProduct(@RequestBody @Valid Product product) {
		return productService.addProduct(product);
	}
	
	//é um construtor que é utilizado para injetar uma instância de CompanyConfig no controlador
	public ProductController(CompanyConfig companyConfig) {								
        this.companyConfig = companyConfig;
    }
	
	 @GetMapping("/company")
	 //retorna informações da empresa.
	    public CompanyConfig getCompanyInfo() {
		 CompanyConfig company = new CompanyConfig();
		 company.setNamecompany(companyConfig.getNamecompany());
		 company.setCity(companyConfig.getCity());
		 company.setCountry(companyConfig.getCountry());
		    return company;
	 }

}