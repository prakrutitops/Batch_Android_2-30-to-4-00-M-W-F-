fun add(a:Int,b:Int):Int
{
    var c=a-b
    return c
}

fun main()
{
    println("Enter value for c & d")
    var c= readLine()!!.toInt()
    var d= readLine()!!.toInt()

    println(add(b=c,a=d))
}