package com.t88;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeEx 
{
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException 
	{
		
		ObjectInputStream in =new ObjectInputStream(new FileInputStream("E://Harsh.txt"));
		Student s=(Student) in.readObject();
		System.out.println(s.id+" "+s.name);
		
	}
}
