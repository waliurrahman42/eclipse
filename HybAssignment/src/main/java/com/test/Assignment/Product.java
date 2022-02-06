package com.test.Assignment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@Column(name="pid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	
	@Column(name="productname")
	private String productName;
	
	private Double productPrice;
	private String productCompancy;
	
	public Product() {
		
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductCompancy() {
		return productCompancy;
	}

	public void setProductCompancy(String productCompancy) {
		this.productCompancy = productCompancy;
	}
	
	

}
