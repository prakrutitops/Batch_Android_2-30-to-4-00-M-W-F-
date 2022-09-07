interface A1
{
    fun a1()

    fun a2()
    {
        println("a2 executed")
    }
}
interface B1
{
    fun b1()

    fun b2()
    {
        println("b2 executed")
    }
}
class C1 :A1,B1
{
    override fun a1() {
        println("a1 executed")
    }

    override fun b1() {
        println("b1 executed")
    }

}
fun main()
{
    var c=C1()
    c.a2()
    c.a1()
    c.b1()
    c.b2()
}