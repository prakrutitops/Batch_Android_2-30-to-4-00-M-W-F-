package com.t88;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeEx 
{
	public static void main(String[] args) throws IOException 
	{
		
		//Serialize
		
		Student s1 =new Student(101, "Tops");
		FileOutputStream fout = new FileOutputStream("E://Harsh.txt");
		ObjectOutputStream out =new ObjectOutputStream(fout);
		out.writeObject(s1);
		System.out.println("success");
	}
}
