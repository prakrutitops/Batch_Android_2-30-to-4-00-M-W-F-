package com.t108;

import java.util.HashMap;
import java.util.Map;

public class HashMapEx 
{
	public static void main(String[] args) 
	{
		
		HashMap<String,String> map = new HashMap<>();
		
		map.put("A", "Apple");
		map.put("B", "Banana");
		map.put("C", "Cat");
		
		//System.out.println(map.get("A"));
		
		for(Map.Entry m : map.entrySet())
		{
			System.out.println(m.getKey()+" - "+m.getValue());
			
		}
		
	}
}
