package oo

import com.sun.tools.javac.comp.Todo

fun Bicycle.replaceWhell(){
    println("Replacing wheel...")
}

fun Boat.startEngine() : Boolean{
    println("Starting engine...")
    return  true
}

fun main(args: Array<String>) {

    val vehicle : Drivable = Bicycle()

    vehicle.drive()

    // instanceOf < - > is
    if(vehicle is Bicycle){
        vehicle.replaceWhell()
    }else if (vehicle is Boat){
        vehicle.startEngine()
    }

    if (vehicle is Boat && vehicle.startEngine()){
        // Todo - faça alguma coisa
    }

    if (vehicle !is Boat || vehicle.startEngine()){
        // ..
    }

    if (vehicle !is Bicycle){
        return
    }

    vehicle.replaceWhell()

}