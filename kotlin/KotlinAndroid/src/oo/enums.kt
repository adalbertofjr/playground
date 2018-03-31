package oo

enum class Direcao(degree: Double){
    NORTH(0.0), EAST(90.0), SOUTH(180.00), WEST(270.00)
}

enum class Suits{
    HEARTS, SPADES, DIAMONDS, CLUBS
}

fun main(args: Array<String>) {
    val suits = Suits.SPADES

    println(suits)

    val color = when(suits){
        Suits.HEARTS, Suits.DIAMONDS -> "red"
        Suits.SPADES, Suits.CLUBS -> "black"
    }

    println(color)
}