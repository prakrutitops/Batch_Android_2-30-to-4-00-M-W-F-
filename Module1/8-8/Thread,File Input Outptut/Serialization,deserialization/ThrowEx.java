package com.t88;

public class ThrowEx 
{
	static void validate(int age)
	{
		if(age>18)
		{
			System.out.println("Eligible to vote");
		}
		else
		{
			//throw new ArithmeticException("Not Valid");
			try 
			{
				throw new MyExeception();
			}
			catch (MyExeception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Executed");
	}
	public static void main(String[] args) 
	{
		validate(15);
	}
}
