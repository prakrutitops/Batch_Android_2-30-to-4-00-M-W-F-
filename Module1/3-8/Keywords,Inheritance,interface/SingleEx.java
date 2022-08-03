package com.t38;


class A
{
	void a()
	{
		System.out.println("a accessed");
	}
}
class B extends A
{
	void b()
	{
		System.out.println("b accessed");
	}
}



public class SingleEx 
{
	public static void main(String[] args) 
	{
		B b=new B();
		b.b();
		b.a();
	}
}
