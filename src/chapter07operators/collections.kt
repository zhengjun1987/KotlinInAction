package chapter07operators

import java.time.LocalDate

/**
 *   Author:Zheng Jun
 *   E-mail:zhengjun1987@outlook.com
 *   Date:14/11/2018 00:03
 *   Project:KotlinInAction
 */

operator fun Point.get(index: Int): Int {
    return when (index) {
        0 -> this.x
        1 -> this.y
        else -> throw IllegalArgumentException("Invalid coordinate $index")
    }
}

class ModifiblePoint(var x: Int, var y: Int) {
    operator fun set(index: Int, value: Int) {
        when (index) {
            0 -> {
                x = value
            }
            1 -> {
                y = value
            }
            else -> {
                throw IllegalArgumentException("Invalid coordinate $index")
            }
        }
    }

    override fun toString(): String {
        return "ModifiablePoint(x=$x, y=$y)"
    }
}

data class Rectangle(val upperLeft: Point, val lowerRight: Point)

operator fun Rectangle.contains(point: Point): Boolean {
    return point.x in upperLeft.x until lowerRight.x && point.y in upperLeft.y until lowerRight.y
}

operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> = object : Iterator<LocalDate> {
    var current: LocalDate = start
    override fun hasNext(): Boolean {
        return current < endInclusive
    }

    override fun next(): LocalDate {
        current = current.plusDays(1)
        return current
    }
}

fun main(args: Array<String>) {
    val point = Point(10, 20)
    println("point[0] = ${point[0]}")
    println("point[1] = ${point[1]}")

    val modifiblePoint = ModifiblePoint(10, 20)
    println("modifiablePoint = $modifiblePoint")
    modifiblePoint[1] = 40
    println("modifiablePoint = $modifiblePoint")

    var intRange = 0 until 9
    println("intRange = $intRange")
    println("9 in intRange = ${9 in intRange}")
    println("7 in intRange = ${7 in intRange}")
    println("8 in intRange = ${8 in intRange}")
    println("0 in intRange = ${0 in intRange}")
    for (i in intRange) {
        println("i = $i")
    }
    intRange = 19 until 10
    println("intRange = $intRange")
    println("10 in intRange = ${10 in intRange}")
    println("20 in intRange = ${20 in intRange}")
    println("8 in intRange = ${8 in intRange}")
    println("11 in intRange = ${11 in intRange}")

    val rectangle = Rectangle(Point(10, 20), Point(50, 50))
    println("Point(20,30) in rectangle = ${Point(20, 30) in rectangle}")
    println("Point(5,5) in rectangle = ${Point(5, 5) in rectangle}")

    for (i in intRange) {
        println("i = $i")
    }
    println("==============================")
    //rangeTo与downTo的区别和共同点
    for (i in 19 downTo 10) {
        println("i = $i")
    }

    val now = LocalDate.now()
    val vacation = now..now.plusDays(7)
    println("now.plusWeeks(1) in vacation = ${now.plusWeeks(1) in vacation}")

    val newYear = LocalDate.ofYearDay(2019, 1)
    val days = newYear.minusDays(1)..newYear
    for (day in days) {
        println("$day => ${day.dayOfWeek}")
    }

    val mutableList = mutableListOf(1, 2, 3)
    println("mutableList = ${mutableList}")
    mutableList.exchange(0,2)
    println("mutableList = ${mutableList}")
}