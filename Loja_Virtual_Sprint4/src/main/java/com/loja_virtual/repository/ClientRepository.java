package com.loja_virtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loja_virtual.model.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	Client findByEmail(String email);
	
}
