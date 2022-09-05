fun main()
{
    var a = IntArray(5)

    for(i in 0..4)
    {
        println("enter number :")
        val data = readLine()!!.toInt()
        a[i]=data
    }

    for(i in 0..4)
    {
      println(a[i])
    }


}