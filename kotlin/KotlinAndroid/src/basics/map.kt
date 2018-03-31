package basics

fun main(args: Array<String>) {

    // map()
    val list = (1..5).toList()

    val doubled = list.map { element -> element * 2 }
    val doubledIt = list.map { (it * 2) }


    println(list)
    println(doubled)
    println(doubledIt)

    println("=========")
    println()

    val average = list.average()
    val shifted = list.map { (it - average) }

    println(average)
    println(shifted)

    // flatMap()
    println("=========")
    println()

    val nestedList = listOf(
            (1..10).toList(),
            (11..20).toList(),
            (21..30).toList()
    )

    val notFlattened = nestedList.map { it.sortedDescending() }
    val flattened = nestedList.flatMap { it.sortedDescending() }

    println(notFlattened)
    println(flattened)

}