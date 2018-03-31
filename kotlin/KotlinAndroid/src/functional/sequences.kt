package functional

import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {

    val veryLongList = (1..9999999L).toList()

   /* val sum = veryLongList
            .asSequence() // lazy collection
            .filter { it > 5 }
            .map { it * 2 }
            .take(3)
            .sum()

    val seq = generateSequence(1, { it + 1})


    println(veryLongList)
    println(sum)

    println(seq.take(10).toList())*/


    var soma = 0L
    var somaLazy = 0L

    val nonLazyMs = measureTimeMillis {
        soma = veryLongList
                .filter { it > 50 }
                .take(1000)
                .map { it * 2 }
                .sum()
    }

    val lazyMs = measureTimeMillis {
        somaLazy = veryLongList
                .asSequence()
                .filter { it > 50 }
                .take(1000)
                .map { it * 2 }
                .sum()
    }

    println("Non-Lazy: $nonLazyMs ms, Result: $soma")
    println("Lazy: $lazyMs ms, Result: $somaLazy")


}