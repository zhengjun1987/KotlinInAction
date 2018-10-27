package chapter03functions

const val LINE_SEPARATOR = "\n"

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

    println("joinToString(list,\";\",\"(\",\")\") = ${JoinKt().joinToString(list, ";", "(", ")")}")
    println(JoinKt().joinToString(collection = listOf, postfix = "]", prefix = "[", separator = " ; "))

    println(chapter03functions.JoinKt().joinToString(collection = set))
    println(chapter03functions.joinToString(collection = set))
    println(joinToString(collection = set))

    println(set.joinToString(",","[","]"))
    println(set.joinToString(prefix = "<",postfix = ">",separator = ","))
    println(list.joinToString(separator = "-"))
    println(listOf.joinToString())

    println(set.join(",","[","]"))
    println(set.join(prefix = "<",postfix = ">",separator = ","))
    println(list.join(separator = "-"))
    println(listOf.join())

    println(set.toString())
    println(list.toString())
    println(listOf.toString())
}

fun <T> Collection<T>.joinToString(
        separator:String="",
        prefix:String="",
        postfix:String=""
):String {
    val stringBuffer = StringBuffer(prefix)
    for (i in 0..this.size - 2) {
        stringBuffer.append(this.elementAt(i).toString())
        stringBuffer.append(separator)
    }
    stringBuffer.append(this.last().toString())
    stringBuffer.append(postfix)
    return stringBuffer.toString()
}

//fun Collection<String>.join(
//        separator: String="",
//        prefix: String="",
//        postfix: String=""
//):String = joinToString(separator,prefix, postfix)

fun Collection<Int>.join(
        separator: String="",
        prefix: String="",
        postfix: String=""
):String = joinToString(separator,prefix, postfix)

fun Collection<Int>.toString():String = this.join(",")//Extension is shadowed by a member:public open fun toString()