package oo

// private -  igual ao Java, acesso na mesma classe
// protected - igual ao Java, acesso na mesma classe e subclasses
// internal  - visivil no mesmo módulo, neste caso no módulo -> KotlinAndroid
// public - igual ao Java, acesso em todas as classes

open class Car(val brand: String, private val model: String) {


    fun tellMeYourModel() = model
}

class Uno(brand: String, model: String) : Car(brand, model){
    fun a(){
        tellMeYourModel()
    }
}


fun main(args: Array<String>) {
    val car = Uno(brand = "Brand", model = "Model")
    car.brand
    car.tellMeYourModel()
}