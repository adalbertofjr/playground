package oo


fun Int.isEven() = this % 2 == 0

fun City.isLarge() = population > 1_000_000

fun main(args: Array<String>) {
    println(5.isEven())

    var naturals = listOf(2, 3, 4, 5, 6, 8)

    println(naturals.filter { it.isEven() })

    val votuporanga = City()
    votuporanga.name = "Votuporanga"
    votuporanga.population = 80_000

    println(votuporanga.isLarge())

}