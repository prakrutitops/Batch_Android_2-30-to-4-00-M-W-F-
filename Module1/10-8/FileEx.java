package com.t108;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileEx 
{
	public static void main(String[] args) 
	{
		
		try 
		{
			FileInputStream fin=new FileInputStream("E://xyz.txt");
			Byte b=(byte) fin.read();
			b.toString();
			
			
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
