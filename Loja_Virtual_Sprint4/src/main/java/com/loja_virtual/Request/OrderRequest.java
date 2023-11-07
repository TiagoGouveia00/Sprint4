package com.loja_virtual.Request;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
	
	
	private String number;
	private long client;
	private List<Long> orderitems = new ArrayList<>();
}
