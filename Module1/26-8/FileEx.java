package com.t268;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileEx 
{
	//FileOutputStream-Write
	//FileInputStream-Read
	
	public static void main(String[] args) 
	{
		
			//File Create and Data Write
			
			
			try 
			{
				String s="Welcome to tops";
				FileOutputStream fout = new FileOutputStream("://Ankit.txt");
				fout.write(s.getBytes());
				System.out.println("Success");
			}
			catch (FileNotFoundException e) 
			{
				// TODO Auto-generated catch block
				System.out.println("Path Does not Exist");
			} 
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
			System.out.println("Success");
		
		
	}
	
}
