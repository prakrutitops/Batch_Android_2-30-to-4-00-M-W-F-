fun add1(a:Int,b:Int):Int
{
    var c=a+b

    return c
}
fun add2(a:Int,b:Int)
{
    var c=a+b
    println(c)

}

fun add3()
{
    var a=5
    var b=6
    var c=a+b
    println(c)

}

fun add4():Int
{
    var a=5
    var b=6
    var c=a+b

    return c

}


fun main()
{
    println(add1(5,6))
    add2(5,6)
    add3()
    println(add4())
}