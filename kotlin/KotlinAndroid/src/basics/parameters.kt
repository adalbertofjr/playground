package basics

fun main(args: Array<String>){
    val languages = listOf("Kotlin", "Java", "Scala")
    val together = concat(texts = languages)
//    val together = concat(separator = " : ", texts = languages)

    println(together)

}

fun concat(texts: List<String>, separator : String = ", ") : String = texts.joinToString(separator)