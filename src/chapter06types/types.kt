package chapter06types

import java.lang.IllegalStateException

/**
 *   Author:Zheng Jun
 *   E-mail:zhengjun1987@outlook.com
 *   Date:5/11/2018 21:00
 *   Project:KotlinInAction
 */

fun showProgress(progress: Int) {
    val percent = progress.coerceIn(0..100)
    println("We're $percent% done!")
}

data class Resident(val name: String, val age: Int? = null) {
    fun isOlderThan(other: Resident): Boolean? {
        if (age == null || other.age == null) {
            return null
        }
        return age > other.age
    }
}

interface Processor<T>{
    fun process():T
}

class NoResultProcessor:Processor<Unit>{
    override fun process() {
        println("do stuff...no return")
    }
}

fun fail(message:String):Nothing{
    throw IllegalStateException(message)
}

fun main(args: Array<String>) {
    showProgress(146)

    println(Resident("Sam", 35).isOlderThan(Resident("Amy", 42)))
    val jane = Resident("Jane")
    println(Resident("Sam", 35).isOlderThan(jane))

    val i = 1
    val l: Long = i.toLong()

    val listOf = listOf(1L, 2L, 3L)
    println("i in listOf = ${i.toLong() in listOf}")
    println("i+l = ${i + l}")

    val answer: Any = 42
    println("answer = ${answer.javaClass.canonicalName}")//java.lang.Integer

    val age = jane.age ?: fail("Null age!")
    println("age = $age")
}