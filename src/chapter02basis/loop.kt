package chapter02basis

import java.util.*

fun fizzBuzz(i: Int) =
        when {
            i % 15 == 0 -> "FizzBuzz "
            i % 5 == 0 -> "Buzz "
            i % 3 == 0 -> "Fizz "
            else -> "$i "
        }


fun main(args: Array<String>) {
    for (i in 0..100 step 2) {
        print(fizzBuzz(i))
    }
    println()
    for (i in 100 downTo 0 step 2) {
        print(fizzBuzz(i))
    }
    println()
    val treeMap = TreeMap<Char, String>()
    for (c in 'A'..'F') {
        val binaryString = Integer.toBinaryString(c.toInt())
        treeMap[c] = binaryString
    }
    for ((key, value) in treeMap) {
        println("$key => $value")
    }
    val arrayList = arrayListOf("10", "11", "1001")
    println("arrayList = ${arrayList.javaClass.canonicalName}")
    arrayList.forEach { each ->
        println("$each => ${Integer.parseInt(each)}")
    }
    val withIndex = arrayList.withIndex()
    println("withIndex = $withIndex")
    println("withIndex = ${withIndex.javaClass.canonicalName}")
    withIndex.forEach {
        println("${it.index} => ${Integer.valueOf(Integer.parseInt(it.value))}")
    }

    println("isNotDigit('x') = ${isNotDigit('x')}")
    println("isLetter('q') = ${isLetter('q')}")
    for (c in '0'..'z') {
        println("recognize(\'$c\') = ${recognize(c)}")
    }
    println("\"Kotlin\" in \"Java\"..\"Python\" = ${"Kotlin" in "Java".."Python"}")
    println("\" Kotlin \" in setOf(\" Java \",\" Scala \") = ${"Kotlin" in setOf("Java", "Scala")}")
}

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c:Char) = c !in '0'..'9'
fun recognize(c: Char) = when (c) {
        in '0'..'9' -> "Digit"
        in 'a'..'z' , in 'A'..'Z' -> "Letter"
        else -> "Unknown Character"
    }