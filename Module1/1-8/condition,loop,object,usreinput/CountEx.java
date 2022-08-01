package com.t18;

public class CountEx 
{
	static int count=0;
	
	public CountEx() 
	{
		// TODO Auto-generated constructor stub
		count++;
		System.out.println(count);
	}
	public static void main(String[] args) {
	
		
		CountEx c1 =new CountEx();
		CountEx c2 =new CountEx();
		CountEx c3 =new CountEx();
		
	}
	
}
