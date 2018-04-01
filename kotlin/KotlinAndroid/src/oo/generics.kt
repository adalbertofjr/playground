package oo

import java.util.*


class Timeline<E> {

    val date2Data: MutableMap<Date, E> = mutableMapOf()

    fun add(element: E) {
        date2Data.put(Date(), element)
    }

    fun getLast(): E = date2Data.values.last()

    fun getFirst(): E = date2Data.values.first()
}


// Generic Function
fun <E> timelineOf(vararg elements: E): Timeline<E> {
    val result = Timeline<E>()
    for (element in elements) {
        result.add(element)
    }

    return result
}

fun main(args: Array<String>) {
    val timeline: Timeline<Int> = Timeline()
    timeline.add(2)

    println(timeline.getLast())
//    println(timeline.getFirst())

    val timeline2: Timeline<String> = timelineOf("", "", "")
    val timeline3: Timeline<Int> = timelineOf(1, 2, 3)
}