fun main()
{

    var marks= intArrayOf(1,2,3,4,5,6)

   /* for(element in marks)
    {
        println(element)
    }*/
    marks[1] = 12
    for(element in marks)
    {
        println(element)
    }
    println(marks.contains(1))
    println(marks.indexOf(3))
}