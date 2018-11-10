package chapter07operators

import java.math.BigDecimal

/**
 *   Author:Zheng Jun
 *   E-mail:zhengjun1987@outlook.com
 *   Date:10/11/2018 21:43
 *   Project:KotlinInAction
 */

operator fun Point.unaryMinus(): Point = Point(-this.x, -this.y)

operator fun BigDecimal.inc(): BigDecimal = this + BigDecimal.ONE

fun main(args: Array<String>) {
    var point = Point(10, 30)
    println("point = $point")
    println("-point = ${-point}")

    var zero = BigDecimal.ZERO
    println("++zero = ${++zero}")
    println("zero++ = ${zero++}")
    println("finally, zero = $zero")
}