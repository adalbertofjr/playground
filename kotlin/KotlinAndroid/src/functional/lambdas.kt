package functional

fun main(args: Array<String>) {

    val timesTwo = { x: Int -> x * 2 }

    println(timesTwo(2))

    val add: (Int, Int) -> Int = { x, y -> x + y }

    println(add(2,3))

    val list = (1..100).toList()

    println(list.filter({ element -> element % 2 == 0 }))

    println(list.filter({it % 2 == 0 }))
    
    println(list.filter({it.even() }))

    println(list.filter(::isEven))

    println(list.filter { it.even() })
}

fun Int.even() = this % 2 == 0

fun isEven(i: Int) = i % 2 == 0

