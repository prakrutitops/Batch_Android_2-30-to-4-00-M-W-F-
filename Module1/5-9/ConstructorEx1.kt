class ConstructorEx1(var id:Int,var name:String)
{


    fun detail()
    {

        var name="ankit"

        println("your id is $id")
        println("your name is $name")
    }
    fun a1(name:String)
    {

        println("Your name is $name")
    }
    fun a2()
    {

    }

}
fun main()
{
    var c1 =ConstructorEx1(101,"a")
    c1.detail()
    c1.a1("a")

}