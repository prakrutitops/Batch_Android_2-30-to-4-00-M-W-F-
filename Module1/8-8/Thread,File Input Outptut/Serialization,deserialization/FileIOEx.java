package com.t88;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOEx 
{
	public static void main(String[] args) throws IOException 
	{
		String s="Welcome to tops";
		FileOutputStream fout =new FileOutputStream("E://tops.txt");
		fout.write(s.getBytes());
		System.out.println("success");
		
	}
}
