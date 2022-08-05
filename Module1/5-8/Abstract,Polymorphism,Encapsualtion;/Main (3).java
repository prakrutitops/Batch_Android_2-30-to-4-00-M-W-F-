//Method Overriding:when method having a same name as well as number of parameters are also 
//same that is called method Overriding.
class Bank
{
    int rate()
    {
        return 0;
    }
}
class Sbi extends Bank
{
    int rate()
    {
        return 7;
    }
}
class Icici extends Bank
{
    int rate()
    {
        return 8;
    }
}
class Axis extends Bank
{
    int rate()
    {
        return 9;
    }
}
public class Main
{
    
	public static void main(String[] args) 
	{
	    
	    Bank b;
	    
	    b=new Sbi();
	    System.out.println(b.rate());
	    b=new Icici();
	    System.out.println(b.rate());
	    b=new Axis();
	    System.out.println(b.rate());
	        
	    
	}
}
