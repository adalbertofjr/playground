package functional

import java.io.FileReader

fun main(args: Array<String>) {

    // use - close, encerra os recurso utilizado como socket, reader e etc como o try-with-resources do java
    FileReader("mayexist.txt").use {
        val str = it.readText()
        println(str)
    }
}