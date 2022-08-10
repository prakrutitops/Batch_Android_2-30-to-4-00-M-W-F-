package com.t108;

import java.util.HashSet;
import java.util.Iterator;

public class MySetEx 
{
	public static void main(String[] args)
	{
		
		HashSet set =new HashSet<>();
		
		set.add("android");
		set.add("java");
		set.add("php");
		set.add("ios");
		set.add("android");
		
		Iterator i =set.iterator();
		
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
		
	}
}
