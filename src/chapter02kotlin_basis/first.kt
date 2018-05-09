package chapter02kotlin_basis

import java.util.*

/**
 *   Author:Zheng Jun
 *   E-mail:zhengjun1987@outlook.com
 *   Date:2018/5/9 21:58
 *   Project:KotlinInAction
 */

fun main(args: Array<String>) {
    println("args = ${Arrays.toString(args)}")
    println("Hello,Kotlin!")
//        args = []
//        Hello,Kotlin!
    println("(max(23,31)) = ${(max(23, 31))}")
    println("(max2(33,31)) = ${(max2(33, 31))}")

    val a1 = 42
    val a2: Int = 42
    println("a1.javaClass.name = ${a1.javaClass.name}")
    println("a2.javaClass.name = ${a2.javaClass.name}")
//            a1.javaClass.name = int
//            a2.javaClass.name = int


}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}
//        (max(23,31)) = 31

fun max2(a: Int, b: Int): Int = if (a > b) a else b
//        (max2(33,31)) = 33