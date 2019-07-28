package chapter02basis

/**
 * Created by zhengjun
 * Date: 2019/7/28
 * Mail:zhengjun1987@outlook.com
 */

fun main(args: Array<String>) {
    val maybeInt: Int? = if (Math.random() > 0.5) null else 1
    println("maybeInt ?: 0 = ${maybeInt ?: 0}")

    for (i in 1..3) {
        //此处并非闭包，而是固定的for语句
        println(i)
    }

    val ints = arrayOf(1, 2, 4, 8)
    for (i in ints) {
        println("2 * i = ${2 * i}")
    }

    for (i in 10 downTo 1 step 2) {
        println("i = ${i}")
    }

    for (i in ints.size - 1 downTo 0 step 1) {
        println("ints[${i}] = ${ints[i]}")
    }

    val closedRange = "ab".."fg"
    println("\" fa \" in closedRange = ${"fa" in closedRange}")

    for (i in 1..3) {
        when(i) {
            1 -> println("i = ${i}")
            else -> println("End!");
        }
    }

    for ((index, value) in ints.withIndex()) {
        println("${index} => ${value}")
    }

    val map = mapOf(
            1 to "One",
            2 to "Two",
            2 to "two",
            3 to "Three"
    )

    println("map = ${map}")

    val strings = arrayOf("L", "m", "n")
    printLetters(*strings,count = 4)
    println()
    printLetters("F","*","C","K",count = 4)
    println()

    val personq = Personq()
    personq called "Shaw"
    personq.called("Bernard")
}

class Personq {
    infix fun called(name:String){
        println("My name is ${name}")
    }
}

fun printLetters(vararg letters:String,count:Int){
    print("${count} letters are:")
    for (letter in letters) {
        print(letter)
    }
}

enum class DayOfWeek(val day: Int) {
    MON(1),
    TUE(2),
    WED(3),
    THU(4),
    FRI(5),
    SAT(6),
    SUN(7)
}

fun schedule(day: DayOfWeek, sunny: Boolean) = {
    when (day) {
        DayOfWeek.MON -> "Basketball"
        DayOfWeek.TUE -> "Fishing"
        DayOfWeek.WED -> "Running"
        DayOfWeek.THU -> "Basketball"
        DayOfWeek.FRI -> "Appointment"
        else -> when (sunny) {
            true -> "Library"
            false -> "Study"
        }
    }
}

infix fun <A,B> A.to(b:B):Pair<A,B> {
    return Pair(this,b)
}