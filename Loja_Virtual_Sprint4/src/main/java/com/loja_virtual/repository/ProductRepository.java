package com.loja_virtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loja_virtual.model.Product;

@Repository //responsavel por interagir com BD
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByCode(String code);

}

