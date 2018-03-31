package functional

inline fun modifystring(str : String, operator: (String) -> String ) : String{
    return operator(str)
}


fun main(args: Array<String>) {

    println(modifystring("Kotlin is amazing", {it.toLowerCase()}))
}