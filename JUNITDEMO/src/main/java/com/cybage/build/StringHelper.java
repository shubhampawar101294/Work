package com.cybage.build;

public class StringHelper {

	
	public String truncateInFirst2Position(String str){
		
		if(str.length()<=2) {
			return str.replace("A","");
		}
		
		String first2Char=str.substring(0,2);
		String MinusFirst2Char=str.substring(2);
		System.out.println(first2Char+" " +MinusFirst2Char);
		
		return first2Char.replaceAll("a", "")+MinusFirst2Char;
	}
	
	public boolean areFirstLast2Char(String str) {
		
		if(str.length()<=1)
			return false;
		if(str.length()==2)
			return true;
		
		String First2Char=str.substring(0,2);
		String last2Char=str.substring(str.length()-2);
		return First2Char.equals(last2Char);
	}
	
	
}
