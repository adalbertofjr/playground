package basics

import java.util.*
import kotlin.collections.ArrayList

val PI = 3.1415

fun main(args: Array<String>){

    //Desafio 1
   /* val anonimo = "Anônimo"

    println("Qual é o seu nome?")
    var input = readLine()

    var name = if(input.isNullOrEmpty()){
        anonimo
    }else{
        input
    }

    val messagem = if(name.equals(anonimo)){
        "Prefere manter sua privacidade, $name"
    }else{
        "Seja bem vindo $name, agora todos sabem o seu nome :)."
    }

    print(messagem)*/

    //Desafio 2
    val randoms: MutableList<Int> = mutableListOf()

    for(i in 1 ..100){
        randoms.add(Random().nextInt(100) + 1)
    }

    var i = 0

  /*  println(randoms)

    println("===========================")*/

     while (randoms[i] > 10){
        println(randoms[i])
        i++
    }



}