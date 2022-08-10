package com.t108;

import java.util.ArrayList;
import java.util.Collections;

class Student2 implements Comparable<Student2>
{
	int sid;
	String sname;
	
	public Student2(int id,String name)
	{
		sid=id;
		sname=name;
	}
	
	
	@Override
	public int compareTo(Student2 o) 
	{
		int value=0;
		
		if(this.sid>o.sid) 
		{
			return 1;
		}
		
		else if (this.sid<o.sid) 
		{
			return -1;
		}
		
		else if(this.sid==o.sid)
		{
			return 0;
		}
		
		return value;
	}
	
}

public class ComparableEx 
{	
		public static void main(String[] args) 
		{
			
			Student2 s1 = new Student2(15, "Parth");
			Student2 s2 = new Student2(10, "Jay");
			Student2 s3 = new Student2(1, "Dhaval");
			Student2 s4 = new Student2(12, "RAhul");
			Student2 s5 = new Student2(7, "Tapan");
			
			
			ArrayList<Student2> al =new ArrayList<Student2>();
			al.add(s1);
			al.add(s2);
			al.add(s3);
			al.add(s4);
			al.add(s5);
			
			
			Collections.sort(al);
			
			for(Student2 s :al) 
			{
				System.out.println("Id : - "+s.sid+"  Name : - "+s.sname);
			}
			
			
			
			
			
			
			
			
			
			
			
		}
}
