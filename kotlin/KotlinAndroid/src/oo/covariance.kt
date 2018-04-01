package oo


open class Being
open class Person : Being()

class Student : Person()


fun main(args: Array<String>) {

    // Covariant = we can use a "more derived" type (a subtype)

    val people : MutableList<Person> = mutableListOf(Person(), Person())
    people.add(Person())
    people.add(Student()) // covariance


    // Being does not fullfill the contract of class Person
    // people.add(Being())

    val p : Person = Student() // covariance

    // Read only collection are covariant
    val students: List<Person> = listOf<Student>()

}