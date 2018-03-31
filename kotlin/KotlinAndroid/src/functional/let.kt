package functional

import java.io.File

fun main(args: Array<String>) {

    //let()

    //Scoping
//    File("example.txt").bufferedReader().let {
//        if(it.ready()){
//            println(it.readLine())
//        }
//    }

    val str: String? = "Kotlin for Android"

    str?.let {
        if(it.isNotEmpty()){
            println( it.toLowerCase())
        }
    }
}