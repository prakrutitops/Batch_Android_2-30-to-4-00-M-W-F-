fun main()
{
    var list = mutableListOf<String>("a1","b1","c1","d1")

    list.add("e")
    list.add("d")

    var list2 = mutableListOf<String>("a","b","c","d")

    /*list.addAll(list2)
    list.removeAt(1)
    list.removeAll(list2)*/

    list.retainAll(list2)
    for(i in list)
    {
        println(i)
    }
}