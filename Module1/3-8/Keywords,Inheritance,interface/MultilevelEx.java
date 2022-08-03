package com.t38;

class P
{
	void p()
	{
		System.out.println("P Accessed");
	}
}
class Q extends P
{
	void q()
	{
		System.out.println("Q Accessed");
	}
}
class R extends Q
{
	void r()
	{
		System.out.println("R Accessed");
	}
}

public class MultilevelEx 
{
	public static void main(String[] args) 
	{
		R r =new R();
		
		r.p();
		r.q();
		r.r();
	}
}
