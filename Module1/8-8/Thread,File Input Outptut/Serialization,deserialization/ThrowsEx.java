package com.t88;

import java.io.IOException;

class M
{
	void m1() throws IOException
	{
		System.out.println("M Executed");
	}
}
class N extends M
{
	void n1() throws IOException 
	{
		System.out.println("-----------------------");
		m1();
		System.out.println("N Executed");
	}
}
class P extends N
{
	void p1() throws IOException 
	{
		System.out.println("-----------------------");
		n1();
		System.out.println("P Executed");
	}
}


public class ThrowsEx 
{
	public static void main(String[] args) throws IOException 
	{
		
		P p =new P();
		
		p.m1();
		p.n1();
		p.p1();
		
	}
}
