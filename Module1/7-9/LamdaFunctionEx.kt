class MyFirstClass
{
    fun addTwoNum(a: Int , b : Int,action:(Int)->Unit)
    {
        val sum = a+b
        action(sum)
    }

}
fun main()
{
    var a=MyFirstClass()
    val myLambda : (Int) -> Unit= { s : Int ->println(s)}
    a.addTwoNum(5,2,myLambda)
}