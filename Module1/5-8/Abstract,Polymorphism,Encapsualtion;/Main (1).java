//Method Overloading:when method having a same name but number of parameters are diffrent

public class Main
{
    static int add(int a,int b)
    {
        return a+b;
    }
    static double add(double a,double b)
    {
        return a*b;
    }
    
    
	public static void main(String[] args) 
	{
	    
	    System.out.println(add(2,3));
	    System.out.println(add(2.5,2.5));
	    
	        
	    
	}
}
