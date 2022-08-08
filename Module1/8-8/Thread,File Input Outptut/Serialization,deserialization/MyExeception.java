package com.t88;

public class MyExeception extends Exception
{
	
	public MyExeception() 
	{
		System.out.println("Your age is not eligible");
		
	}
	
	public static void main(String[] args) {
		
		MyExeception m1 =new MyExeception();
		
	}
}
