open class M
{
    fun m1()
    {
        println("M1 Executed")
    }
}
open class N :M()
{
    fun n1()
    {
        println("N1 Executed")
    }
}
interface  P
{
    fun p1()
    {
        println("P1 Executed")
    }
}

class HybridEx :N(),P
{


}
fun main()
{
    var h =HybridEx()
    h.m1()
    h.n1()
    h.p1()
}