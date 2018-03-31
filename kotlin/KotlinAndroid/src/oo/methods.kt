package oo

class Robot(val name: String){

    fun greetingHumans(){
        println("Hello humans, my name is $name")
    }

    fun knowsItsName(): Boolean = name.isNotBlank()
}

fun main(args: Array<String>) {
    val fightRobot = Robot("T9000")

    if (fightRobot.knowsItsName()){
        fightRobot.greetingHumans()
    }
}