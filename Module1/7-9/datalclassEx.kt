data class Student(var id:Int,var name:String)
{

}
fun main()
{
    var s=Student(101,"a")
    var s2=Student(101,"a")
    println(s)
    if(s==s2)
    {
        println("True")
    }
    else
    {
        println("False")
    }

    var s3=s.copy()
    println(s3)
}
