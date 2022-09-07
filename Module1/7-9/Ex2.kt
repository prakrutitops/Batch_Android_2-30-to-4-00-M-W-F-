sealed class A2
{
    class B :A2()
    object C :A2()
}

fun main()
{
    val x : A2 =A2.C

    val output = when(x)
    {
        is A2.B->"B class"
        is A2.C->"object"
    }
    println(output)
}