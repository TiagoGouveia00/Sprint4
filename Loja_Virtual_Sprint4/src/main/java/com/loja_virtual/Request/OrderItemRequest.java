package com.loja_virtual.Request;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemRequest {
	
	@NotNull
	private long product;
    private int quantity;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;
    
}


