package com.t88;

import java.io.Serializable;

public class Student implements Serializable
{
	
	//Serializable-Serialize(outputstream-write)   ,Deserialize(inputstream-read)
	int id;
	String name;
	
	public Student(int id,String name) 
	{
		// TODO Auto-generated constructor stub
		this.id=id;
		this.name=name;
	}
}
