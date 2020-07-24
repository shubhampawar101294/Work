package com.cybage.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Discount {
	
	public Discount(String name, String product, String discount, Date startDate, Date endDate, Date updatedDate) {
		super();
		this.name = name;
		this.product = product;
		this.discount = discount;
		this.startDate = startDate;
		this.endDate = endDate;
		this.updatedDate = updatedDate;
	}

	public Discount() {
		super();
	}
     

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;

	@Column
	String name;

	@Column
	String product;

	@Column
	String discount;

	@Column
	Date startDate;

	@Column
	Date endDate;
	
	@Column
	Date updatedDate;

	
	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
