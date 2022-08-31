package com.t298;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListEx 
{
	public static void main(String[] args) {
		
		ArrayList arrayList =new ArrayList<>();
		
		arrayList.add(1);
		arrayList.add("1234");
		
		//System.out.println(arrayList);
		
		ArrayList arrayList2 =new ArrayList<>();
		
		arrayList2.add("a");
		arrayList2.add("b");
		arrayList2.add(1);
		
		//arrayList.addAll(arrayList2);
		
		//arrayList.remove(1);
		//arrayList.removeAll(arrayList2);

		arrayList.retainAll(arrayList2);
		
		Iterator i =arrayList.iterator();
		
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
		
	}
}
