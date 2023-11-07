package com.loja_virtual.repository;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Configuration
@EntityScan(basePackages = "com.loja_virtual.order")
public class JpaConfig {
    @PersistenceContext
    private EntityManager entityManager;
}
