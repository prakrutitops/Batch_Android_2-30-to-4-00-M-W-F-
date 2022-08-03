package com.t38;

public class ParaEx 
{
	
	int id;
	String name;
	
	public ParaEx(int id,String name) 
	{
		// TODO Auto-generated constructor stub
		
		this.id=id;
		this.name=name;
	}
	
	void display()
	{
		System.out.println(id+" "+name);
	}
	
	public static void main(String[] args) 
	{
		
		ParaEx p1 =new ParaEx(101,"Xyz");
		ParaEx p2 =new ParaEx(102, "Abc");
		
		p1.display();
		p2.display();
	}
}
