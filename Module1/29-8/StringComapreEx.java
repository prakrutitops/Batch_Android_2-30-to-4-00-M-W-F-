package com.t298;

public class StringComapreEx 
{
	public static void main(String[] args) {
		
		
		String s1="Sachin";
		
		String s2 ="Sachin";
		
		String s3 =new String("SACHIN");
		
		String s4=new String("Ratan");
		
		String s5 =new String("Sachin");
		
		System.out.println(s1.equals(s2));
		System.out.println(s1.equalsIgnoreCase(s3));
		
		System.out.println(s1.equals(s5));//value
		System.out.println(s1==s5);//value way
		
		System.out.println(s1.compareTo(s4));
	}
}
