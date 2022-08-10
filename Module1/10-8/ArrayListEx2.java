package com.t108;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListEx2 
{
	public static void main(String[] args) 
	{
		
		ArrayList arrayList = new ArrayList<>();
		
		arrayList.add("android");
		arrayList.add("java");
		arrayList.add("php");
		arrayList.add("python");
		arrayList.add("ios");
		ArrayList arrayList2 = new ArrayList<>();
		
		arrayList2.add("android");
		arrayList2.add("java");
		arrayList2.add("php1");
		
		arrayList.addAll(arrayList2);
		arrayList.remove(1);
		arrayList.remove("php");
		arrayList.removeAll(arrayList2);
		
		Iterator i =arrayList.iterator();
		
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
		
		
		
	}
}
