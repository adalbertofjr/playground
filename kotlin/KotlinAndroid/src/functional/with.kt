package functional

fun main(args: Array<String>) {

    val props = System.getProperties()

    // quando é necessário fazer váras chamada
    with(props) {
        list(System.out)
        println(propertyNames().toList())
        println(getProperty("user.home"))
    }

}