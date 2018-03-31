package basics

import java.io.IOException

fun main(args: Array<String>) {

    val input = try{
        getExternalInput()
    }catch (e: IOException){
        e.printStackTrace()
        ""
    }finally {
        println("Finished trying to read external input")
    }

    println(input)
}

fun getExternalInput(): String? {
    val input = readLine()

    if (input.isNullOrEmpty()) throw IOException("Coul not read external input")

    return input
}