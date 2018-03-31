package oo

class Country(val name: String, val area: Int){

    constructor(name: String): this(name, 0){
        println("Second constructor")
    }

    fun print() = "$name, $area kmˆ2"

}

fun main(args: Array<String>) {
    val australia = Country("Australia", 7_000_000)
    println(australia.name)
    println(australia.area)

    val espanha = Country("Espanha")
    println(espanha.name)
    println(espanha.area)
    println(espanha.print())


}