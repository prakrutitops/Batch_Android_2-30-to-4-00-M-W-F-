fun main()
{
   println("Enter your name")
   var name1= readLine()

   println("Enter your surname")
    var surname1= readLine()

   println("Enter your email")
    var email1= readLine()

   println("Enter your Mobile")
    var mobile1= readLine()!!.toLong()

    println("Enter your percentage")
    var perce1= readLine()!!.toFloat()

    details(name = name1!!,surname = surname1!!,mobile = mobile1,email = email1!!,percentage = perce1 )
}