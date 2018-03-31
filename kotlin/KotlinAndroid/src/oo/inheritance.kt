package oo

//Minima example
open class Base // by default class are closed on Kotlin, in Java is open
class Child : Base()

open class Shape1(val name: String){

    open fun area() = 0.0

}

class Circle1(name: String, val radius: Double) : Shape1(name){

    override fun area() = Math.PI * Math.pow(radius, 2.0)
}

fun main(args: Array<String>) {

    val circle = Circle1(name = "Small Circle", radius = 2.0)

    println(circle.name)
    println(circle.radius)
    println(circle.area())
}