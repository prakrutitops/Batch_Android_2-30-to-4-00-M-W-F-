import java.io.FileInputStream
import java.io.ObjectInputStream

fun main()
{
    var a1=ObjectInputStream(FileInputStream("E://x.txt"))
    var s:Student1 = a1.readObject() as Student1
    println("${s.id} , ${s.name}")
}