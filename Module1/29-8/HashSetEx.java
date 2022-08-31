package com.t298;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetEx 
{
	
	public static void main(String[] args) {
		
		
		HashSet set =new HashSet<>();
		
		set.add("Android");
		set.add("1");
		set.add("2");
		set.add("3");
		set.add("4");
		set.add("2");
		set.add("android");
		set.add("4");
		set.add(8);
		
		Iterator i =set.iterator();
		
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
		
	}
	
}
