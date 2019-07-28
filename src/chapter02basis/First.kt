package chapter02basis

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
    println("(max(23,31)) = ${(23.max(31))}")
    println("(max2(33,31)) = ${(max2(33, 31))}")

    val a1 = 42
    val a2: Number = 42
    println("a1.javaClass.name = ${a1.javaClass.name}")
    println("a2.javaClass.name = ${a2.javaClass.name}")
    val msg: String
    if (canPerformOperation()) {
        msg = "Success"
    } else {
        msg = "Fail"
    }
    println("msg = $msg")

    val languages = arrayListOf("Java")
    languages.add("Kotlin")
    println("languages = $languages")


    println("45.max(61) = ${45.max(61)}")
    println("61.max(45) = ${61.max(45)}")

    val question = "What is he ultimate question of life, the Universe, and everything?"
    var answer = 42
//    answer = "no answer"  //var类型的变量其值可变，其类型不可变
    //val 不可变引用
    //var 可变引用
    println("question = ${question}")
    println("answer = $answer")
    answer = 3
    println("answer = $answer")


//    msg = question
//    msg是由val定义的，包含有final的意思
//    val key = 42
    val key:Int = 42
    val yearsToCompute = 7.5e6
    println("yearsToCompute = $yearsToCompute")
    println("key = $key")
//    key = 3
    println("key = $key")


}

fun canPerformOperation(): Boolean = Math.random().times(100).toInt().rem(2) == 0

fun Int.max(b: Int) = if (this > b) this else b

fun max2(a: Int, b: Int) = if (a > b) a else b