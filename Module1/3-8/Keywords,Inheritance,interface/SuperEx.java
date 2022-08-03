package com.t38;

class A1
{
	String color="black";
}
class B1 extends A1
{
	String color="white";
	
	void dispaly()
	{
		System.out.println(color);
		System.out.println(super.color);
	}
}

public class SuperEx 
{
	public static void main(String[] args) 
	{
		B1 b =new B1();
		b.dispaly();
	}
}
