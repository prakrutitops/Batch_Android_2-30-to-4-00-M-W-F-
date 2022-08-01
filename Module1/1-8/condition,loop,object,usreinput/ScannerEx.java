package com.t18;

import java.util.Scanner;

public class ScannerEx
{
	public static void main(String[] args) 
	{
		
		Scanner sc =new Scanner(System.in); //object
		
		System.out.println("Enter your Id");
		int id=sc.nextInt();
		
		System.out.println("Enter your Name");
		String name=sc.next();
		
		System.out.println("Enter your Salary");
		double salary=sc.nextDouble();
		
		
		System.out.println(id+" "+name+" "+salary);
		
		if(salary>30000)
		{
			System.out.println("Good to go");
		}
		else
		{
			System.out.println("Need to improve");
		}
	}
}
