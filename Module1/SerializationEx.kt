import java.io.FileOutputStream
import java.io.ObjectOutputStream

fun main()
    {
        var s=Student1(101,"a")
        var fout =FileOutputStream("E://x.txt")
        var out=ObjectOutputStream(fout)
        out.writeObject(s)
        println("success")

    }
