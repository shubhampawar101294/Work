package com.cybage.service;

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
import org.springframework.stereotype.Service;

import com.cybage.dao.DiscountDAO;
import com.cybage.model.Discount;

@Service
public class DiscountServiceimpl implements DiscountService {

	@Autowired
	DiscountDAO discountDAO;

	@Override
	public List<Discount> getAllDiscount() {
		List<Discount> discountList = (List<Discount>) discountDAO.findAll();
		return discountList;
	}

	@Override
	public Discount addDiscount(String discountForm) {
		org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
		Discount returnNewDiscount = null;
		try {
			JSONObject json = (JSONObject) parser.parse(discountForm);
			System.out.println(json.toString());
			//startdate parsing using java 8 date API
			DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
					Locale.ENGLISH);
			LocalDateTime STARTdate = LocalDateTime.parse(json.get("startDate").toString(), inputFormatter);
			ZonedDateTime zdt1 = STARTdate.atZone(ZoneId.systemDefault());
			Date startDateoutput = Date.from(zdt1.toInstant());
			//enddate parsing
			LocalDateTime ENDdate = LocalDateTime.parse(json.get("endDate").toString(), inputFormatter);
			ZonedDateTime zdt2 = ENDdate.atZone(ZoneId.systemDefault());
			Date endDateoutput = Date.from(zdt2.toInstant());

			Discount newDiscount = new Discount(json.get("Name").toString(), json.get("product").toString(),
					json.get("discount").toString(), startDateoutput, endDateoutput, new Date());
			returnNewDiscount = discountDAO.save(newDiscount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnNewDiscount; 
	}

}
