package com.t298;

import java.util.HashMap;
import java.util.Map;

public class HashMapEx 
{
	public static void main(String[] args) {
		
		
		HashMap<String,Integer>map =new HashMap<>();
		
		map.put("A", 101);
		map.put("B", 102);
		map.put("C", 103);
		map.put("D", 104);
		
		for(Map.Entry m :map.entrySet())
		{
			System.out.println(m.getKey()+" "+m.getValue());
		}
		
		System.out.println(map.get("C"));
		
		
		
	}
}
/*for(String s:xyz)
{

}*/