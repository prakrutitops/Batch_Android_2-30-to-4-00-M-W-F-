class Student
{
    fun pass(marks:Int):Boolean
    {
        return marks>40
    }
}

fun Student.scholarship(marks:Int):Boolean
{
    return marks>90
}

fun main()
{
    var s = Student()
    println("Pass Status: "+s.pass(96))
    println("Scholarship Status: "+s.scholarship(96))

}