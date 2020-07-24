package com.cybage.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cybage.model.Discount;

@Repository
public interface DiscountDAO extends CrudRepository<Discount, Long> {

	
}
