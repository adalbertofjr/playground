package functional

fun main(args: Array<String>) {

    val inputRows = listOf(
            mapOf("input01.csv" to listOf(1, 3, 300, 40)),
            mapOf("input02.csv" to listOf(101, 4, 10, 50)),
            mapOf("input03.csv" to listOf()),
            mapOf("input04.csv" to listOf(5, 33, 999, 100))
    )

    val cleaned = inputRows.flatMap { it.values }
            .flatten()
            .filter { it in 0..10 }
            .toIntArray()

    println(cleaned.joinToString())
}