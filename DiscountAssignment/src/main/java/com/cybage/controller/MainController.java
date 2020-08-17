package com.cybage.controller;

import java.awt.PageAttributes.MediaType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.dao.DiscountDAO;
import com.cybage.model.Discount;
import com.cybage.service.DiscountService;

@RestController
public class MainController {

	@Autowired
	DiscountService discountService;

	
	//Servioce to retrieve all discounts
	@RequestMapping(value = "/DiscountsList", method = RequestMethod.GET)
	public List<Discount> getDiscountss() {
		List<Discount> list = discountService.getAllDiscount();
		System.out.println("get List");
		return list;
	}

	//service to add new Discount
	@RequestMapping(value = "/discount", method = RequestMethod.POST)
	public Discount addEmployee(@RequestBody String DiscountForm) throws ParseException {
		Discount newDiscount=discountService.addDiscount(DiscountForm);
		System.out.println(newDiscount.getId());
		return newDiscount;
	}

}
