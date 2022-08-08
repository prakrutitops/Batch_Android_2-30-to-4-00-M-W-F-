package com.t88;

public class TryCatchEx 
{
	public static void main(String[] args) 
	{
			try
			{
				int data=10/0;
				System.out.println(data);//stop
			}
			catch(Exception e)
			{
				//e.printStackTrace();
				System.out.println(e);
			}
			finally 
			{
				System.out.println("success");	
			}
		
			
		
	}
}
