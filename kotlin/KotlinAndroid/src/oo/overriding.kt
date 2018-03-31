package oo

abstract class Vehicle(open val brand: String = ""){
    open fun drive(){
        println("Driving")
    }

    abstract fun honk()
}

class Sedan(override var brand: String = "Brand") : Vehicle(), Drivable{
    override fun drive() {
        super<Drivable>.drive()
    }

    override fun honk() {
        println("Vruuuuuummmmm")
    }

}

fun main(args: Array<String>) {
    val sedan = Sedan()
    sedan.drive()
    sedan.honk()
}