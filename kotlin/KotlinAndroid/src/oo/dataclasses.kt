package oo


//Generate hashcode(), equals(), toString(), coopy(), destructuring operator
data class Address(val street: String, val number: Int, val postcode: String, val city: String)


fun main(args: Array<String>) {

    val resident = Address(street = "Mains street", number = 42, postcode = "1234", city = "New York")
    val resident2 = Address(street = "Mains street", number = 42, postcode = "1234", city = "New York")

    println(resident)

    // Referential equality
    println(resident === resident2)

    // Structural equality, equals()
    println(resident == resident2)

    // copy()
    val neighbor = resident.copy(number = 43)
    println(neighbor)

    // Destructuring operator
    println(resident.component1())

    val (street, number, postcode, city) = resident
    println("$street $number, $postcode $city")

}