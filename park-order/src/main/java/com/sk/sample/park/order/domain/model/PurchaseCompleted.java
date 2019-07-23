package com.sk.sample.park.order.domain.model;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PurchaseCompleted implements Serializable {
	private Long id; 
	private Order order;
}
