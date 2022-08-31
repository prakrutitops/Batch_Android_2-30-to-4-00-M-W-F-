package com.t298;

public class ExtraEx 
{
	public static void main(String[] args) {
		
		String s1 ="sachin";
		String s2="SACHIN";
		String s3="  sachin  ";
		String s4 ="Java is a Programming Language.Java is a platform";
		
		System.out.println(s1.toUpperCase());
		System.out.println(s2.toLowerCase());
		System.out.println(s3.trim());
		System.out.println(s1.charAt(0));
		System.out.println(s4.replace("Java", "Tops"));
		
		System.out.println(s1.startsWith("sa"));
		System.out.println(s1.endsWith("a"));
	}
}
