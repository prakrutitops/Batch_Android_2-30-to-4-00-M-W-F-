package com.t108;

import java.util.Iterator;
import java.util.Vector;

public class VectorEx 
{
	public static void main(String[] args) 
	{
		
		Vector v =new Vector<>(5);
		
		v.add("Android");
		v.add("Java");
		v.add("Php");
		v.addElement("Ios");
		v.add("Android");
		v.add("Java");
		v.add("Php");
		v.addElement("Ios");
		v.add("Java");
		v.add("Php");
		v.addElement("Ios");
	
		
		System.out.println(v.size());
		System.out.println(v.capacity());
		
		Iterator i =v.iterator();
		
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
		
		
	}
}
