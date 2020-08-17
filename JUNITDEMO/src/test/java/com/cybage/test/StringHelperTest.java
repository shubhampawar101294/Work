package com.cybage.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cybage.build.StringHelper;

public class StringHelperTest {
	StringHelper helper;
	@Test
	public void test() {
		String actual=helper.truncateInFirst2Position("aabc");
		assertEquals("bc", actual);
		
	}

	@Before
	public void test2() {
		System.out.println("before test... ");
		 helper =new StringHelper(); 

	}
	@After
	public void test3() {
		System.out.println("after test... ");
		 

	}
	@BeforeClass
	public static void test4() {
		System.out.println("beforeclass test... ");

	}
	
	@AfterClass
	public static void test5() {
		System.out.println("afterclass test... ");

	}
	
}
