class Sender
{
    fun send(msg:String)
    {
        println("Sending $msg")

            Thread.sleep(1000)

        println("$msg sent")

    }
}

class P1(var sender: Sender,var msg: String) :Thread()
{
    override fun run()
    {
        synchronized(sender)
        {
            sender.send(msg)
        }
    }
}

fun main()
{
    var sender=Sender()

    var s1=P1(sender,"Hii")
    var s2=P1(sender,"Byee")

    s1.start()
    s2.start()
}

