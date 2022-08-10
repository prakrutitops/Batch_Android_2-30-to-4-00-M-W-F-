package com.t108;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListEx 
{
	public static void main(String[] args) 
	{
		
		ArrayList<String> arrayList=new ArrayList<String>();
		
		arrayList.add("a1");
		arrayList.add("b1");
		arrayList.add("tops");
		arrayList.add("rajkot");
		
		System.out.println(arrayList);
		
		Iterator i =arrayList.iterator();
		
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
		
		
	}
}
