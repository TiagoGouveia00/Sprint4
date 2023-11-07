package com.loja_virtual.company;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component; 

@Component 												//Esta anotação marca a classe como um componente gerido pelo Spring (O Spring será responsável por criar instâncias desta classe e geri-las)
@Configuration
@ConfigurationProperties(prefix = "company")			//esta anotação é utilizada para mapear as propriedades do ficheiro de configuração (application.yml)
public class CompanyConfig {
    private String namecompany;
    private String city;
    private String country;


    public String getNamecompany() {
		return namecompany;
	}

	public void setNamecompany(String namecompany) {
		this.namecompany = namecompany;
	}

	public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
}