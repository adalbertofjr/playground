package oo

class City {

    var name: String = ""
        get() = field
        set(value) {
//            field = value
            if (value.isNotBlank()) {
                field = value
            }
        }

    var population: Int = 0
        get() = field
}

fun main(args: Array<String>) {
    val city = City()
    city.name = "Sao Paulo"
    city.population = 11_000_000

    println(city.name)
    println(city.population)
}