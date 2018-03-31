package functional

fun main(args: Array<String>) {
    val list = listOf("Hi", "there", "Kotlin", "fans")
    val containsT = listOf(false, true, true, false)

    val zipped = list.zip(containsT)
    val mapping = list.zip(list.map { it.contains("n") })

    println(zipped)
    println(mapping)
}