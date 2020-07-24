package com.cybage.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cybage.model.Discount;


public interface DiscountService {

	public List<Discount> getAllDiscount();

	public Discount addDiscount(String discountForm);

}
