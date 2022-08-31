package com.t298;

import java.util.Vector;

public class VectorEx 
{
	public static void main(String[] args) {
		
		
		Vector v =new Vector<>(5);
		
		v.add("a");
		v.add("b");
		v.add("c");
		v.add("b");
		v.add("c");
		
		v.add("c");
		
		System.out.println(v.size());
		System.out.println(v.capacity());
		
		System.out.println(v.firstElement());
		System.out.println(v.lastElement());
		
		
		if(v.contains("d"))
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}
		
	}
}
