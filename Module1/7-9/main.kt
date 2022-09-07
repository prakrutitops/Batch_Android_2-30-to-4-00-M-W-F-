open class A
{
    fun a1()
    {
        println("a1 executed")
    }
}
open class B : A()
{
    fun b1()
    {
        println("b1 executed")
    }
}
class C :B()
{
    fun c1()
    {
        println("c1 executed")
    }
}
fun main(args: Array<String>)
{
    var c=C()
    c.a1()
    c.b1()
    c.c1()

}