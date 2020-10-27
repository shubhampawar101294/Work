package com.cybage.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import utility.Calculator;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JunitCalculator {

	static Calculator cal;
	@BeforeClass
	 public static void befortestPositive() {
		cal = new Calculator();
		System.out.println("cal created");
		
	}

	@Test
	public void testPositive() throws Exception {
		
		Assert.assertEquals("excep",1, cal.sub(3,2));
		
	}
	
	@Test
	public void testNegative() {
		
		Assert.assertEquals(-5, cal.add(-3,-2));
	}
	
	@AfterClass
	public static void aftertestPositive() {
		cal = null;
		System.out.println("cal detroyed");
		
	}
}
