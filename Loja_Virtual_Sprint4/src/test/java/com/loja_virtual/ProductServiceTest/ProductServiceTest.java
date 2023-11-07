package com.loja_virtual.ProductServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.loja_virtual.model.Product;
import com.loja_virtual.repository.ProductRepository;
import com.loja_virtual.service.ProductService;

public class ProductServiceTest {

	@MockBean
	private ProductRepository produtoRepository;

	@Autowired
	private ProductService productService;

	@Test
	public void testListarProdutos() {
		Product produto1 = new Product();
		produto1.setName("Produto1");
		Product produto2 = new Product();
		produto2.setName("Produto2");

		// Configura o comportamento simulado do repositório
		when(produtoRepository.findAll()).thenReturn(Arrays.asList(produto1, produto2));

		List<Product> products = productService.listarProdutos();
		
		// Verifica se o serviço retornou a lista esperada de produtos
		assertEquals(2, products.size());
		assertEquals("Produto1", products.get(0).getName());
		assertEquals("Produto2", products.get(1).getName());
	}

	@Test
	public void testFindByCodeTest() {
		String code = "001";
		Product produto = new Product();
		produto.setCode(code);
		produto.setName("Produto1");
		
		// Configura o comportamento simulado do repositório para retornar o produto quando findByCode é chamado
		when(produtoRepository.findByCode(code)).thenReturn(produto);

		Product produtoEncontrado = productService.findByCode(code);
		
		// Verifica se o produto retornado não é nulo e se os valores correspondem aos esperados
		assertNotNull(produtoEncontrado);
		assertEquals(code, produtoEncontrado.getCode());
		assertEquals("Produto1", produtoEncontrado.getName());
	}

	@Test
	public void testAddProductTest() {
		Product produto = new Product();
		produto.setCode("001");
		produto.setName("Produto1");

		// Configura o comportamento simulado do repositório para retornar o produto
		// quando o método save é chamado
		when(produtoRepository.save(produto)).thenReturn(produto);

		Product savedProduct = productService.addProduct(produto);

		// Verifica se o produto retornado não é nulo e se os valores correspondem aos
		// esperados
		assertNotNull(savedProduct);
		assertEquals("001", savedProduct.getCode());
		assertEquals("Produto1", savedProduct.getName());
	}

}
