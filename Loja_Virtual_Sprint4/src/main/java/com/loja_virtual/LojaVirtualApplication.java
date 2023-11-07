package com.loja_virtual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.loja_virtual.company.CompanyConfig;

@SpringBootApplication
@EntityScan
@EnableConfigurationProperties(CompanyConfig.class) //serve para habilitar a configuração de propriedades personalizadas (neste caso as propriedades da classe CompanyConfig)
public class LojaVirtualApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojaVirtualApplication.class, args);
	}

}
