package functional

fun main(args: Array<String>) {

    val list = (1..30).toList()

    val listTake = list.take(10)
    val listDrop = list.drop(20)

    println(listTake)
    println(listDrop)

    var listGen = generateSequence(1) {
        it + 10
    }

    val first5 = listGen.take(5).toList()
    val first10 = listGen.take(10).toList()

    println(first5)
    println(first10)


}