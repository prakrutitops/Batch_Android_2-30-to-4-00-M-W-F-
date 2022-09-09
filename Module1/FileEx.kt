import java.io.FileOutputStream

fun main()
{
    var s="adasdasdsd"
    var fout =FileOutputStream("E://abc.txt")
    fout.write(s.toByteArray())
    println("success")
}