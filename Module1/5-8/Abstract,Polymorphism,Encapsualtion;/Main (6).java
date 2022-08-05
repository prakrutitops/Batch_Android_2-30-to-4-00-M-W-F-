//abstract class having two type of method 
/*
1.abstract
2.non abstract */

//abstract method can not dewclare in normal class must be in abstract class
//can not instantiate abstract class you have to inherit Iterable

//where you have inherit your abstract class at that place you have to override your method



abstract class A
{
     abstract void add();
     void b()
     {
         System.out.println("bb");
     }
    
    
}
class B extends A
{
    public void add()
    {
        System.out.println("aa");
    }
}
public class Main
{
    public static void main(String[] args) 
	{
	   B b =new B();
	   b.add();
	   b.b();
	        
	  
	    
	}
}
