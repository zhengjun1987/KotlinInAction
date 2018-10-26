package chapter03functions

fun main(args: Array<String>) {
    val set = hashSetOf(1, 7, 53)
    val list = arrayListOf(1, 7, 53)
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
    println("set.javaClass = ${set.javaClass}")
    println("list.javaClass = ${list.javaClass}")//list.javaClass = class java.util.ArrayList
    println("map.javaClass = ${map.javaClass}")

    println("set.first() = ${set.first()}")
    println("list.first() = ${list.first()}")

    println("set.last() = ${set.last()}")
    println("list.last() = ${list.last()}")

    println("set.max() = ${set.max()}")
    println("list.max() = ${list.max()}")

    println("set.min() = ${set.min()}")
    println("list.min() = ${list.min()}")

    println("map.count() = ${map.count()}")

    val listOf = listOf(1, 7, 53)
    println("listOf.javaClass = ${listOf.javaClass}")//class java.util.Arrays$ArrayList
    println("listOf.first() = ${listOf.first()}")
    println("listOf.last() = ${listOf.last()}")
    println("listOf.max() = ${listOf.max()}")
    println("listOf.min() = ${listOf.min()}")

    println("set = $set")
    println("listOf = $listOf")
    println("list = $list")
    println("map = $map")
}