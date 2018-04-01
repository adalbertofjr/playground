package oo

import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent


// Equivalente a um singleton no java, cria somente um objeto e reutiliza
object CountryFactory {
    val a = 4
    fun createCountry() = Country(name = "Brasil")
}


object DefaultClickListener : MouseAdapter() {

    override fun mouseClicked(e: MouseEvent?) {
        println("Mouse was clicked")
    }
}


fun main(args: Array<String>) {

    CountryFactory.a
    CountryFactory.createCountry()
}