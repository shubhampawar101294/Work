package com.cybage.test;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;

import utility.Calculator;

public class Parameterized {
	
	
	int i1;
	int i2;
	int output;
	
	Parameterized(){
		
	}
	Parameterized(int i1,int i2,int output){
		this.i1=i1;
		this.i2=i2;
		this.output=output;
	}
	

	/*
	 * public static Collection List() { return Arrays.asList(new Object[][]
	 * {{1,2,3},{11,22,33}});
	 * 
	 * }
	 */
	
	static Calculator cal;
	@Before
	 public  void befortestPositive() {
		cal = new Calculator();
		System.out.println("cal created");
		
	}

	@Test
	public void testPositive() throws Exception {
		
		Assert.assertEquals("excep",output, cal.sub(i1,i2));
		
	}
}
