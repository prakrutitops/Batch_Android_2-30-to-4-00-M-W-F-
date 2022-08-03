package com.t38;

public class SvmEx 
{
	int id;
	String name;
	static String college="Atmiya";//static variable
	
	public SvmEx(int id,String name) 
	{
		// TODO Auto-generated constructor stub
		this.id=id;
		this.name=name;
	}
	
	void display()
	{
		System.out.println(id+" "+name+" "+college);
	}
	
	static void change()//you can direct call method without creating object
	{
		college="VVP";
	}
	
	public static void main(String[] args) 
	{
			change();
		
			SvmEx s1 =new SvmEx(101,"A");
			SvmEx s2 =new SvmEx(102,"B");
			SvmEx s3 =new SvmEx(103,"C");
			
			s1.display();
			s2.display();
			s3.display();
			
	
	}
}
