package com.t38;

class T
{
	void t()
	{
		System.out.println("t");
	}
}
class U extends T
{
	void u()
	{
		System.out.println("u");
	}
}
interface Y
{
	void y();
}
interface Z 
{
	void z();
}
class V extends U implements Z,Y
{
	void v()
	{
		System.out.println("v");
	}

	@Override
	public void z() 
	{
		// TODO Auto-generated method stub
		System.out.println("z");
	}

	@Override
	public void y() {
		// TODO Auto-generated method stub
		System.out.println("ys");
	}
}

public class HybridEx 
{
	public static void main(String[] args) {
		
		
		V v =new V();
		
		v.t();
		v.u();
		v.v();
		v.z();
		v.y();
		
	}
}
