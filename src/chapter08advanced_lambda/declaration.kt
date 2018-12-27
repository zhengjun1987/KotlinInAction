package chapter08advanced_lambda

import chapter05lambda.Person

/**
 *   Author:Zheng Jun
 *   E-mail:zhengjun1987@outlook.com
 *   Date:18/12/2018 23:36
 *   Project:KotlinInAction
 */

fun main(args: Array<String>) {
    val sum = { x: Int, y: Int -> x + y }
    val action = { println(42) }
    val canReturnNull: (Int, Int) -> Int? = { x, y -> null }

    twoAndThree(sum)
    twoAndThree { x, y -> x * y }
    twoAndThree { x, y -> x / y }
    val filter = "ab1c2d".filter { it in 'a'..'z' }
    println("filter = $filter")

    processTheAnswer { it + 1 }

    val listOf = listOf<String>("Alpha", "Pris", "Collars", "Prado")
    println("listOf = ${listOf.joinToString()}")
    println("listOf = ${listOf.joinToString(transformer = { it.toString().toUpperCase() })}")

    /*2018-12-20 22:23:08*/
    println("getShippingCostCalculator(Delivery.EXPEDITED).invoke(Order(3)) = ${getShippingCostCalculator(Delivery.EXPEDITED).invoke(Order(3))}")

    val persons = listOf(Person("ZhengJun", 31), Person("Frank Underwood", 56))
    val contactListFilters = ContactListFilters()
    with(contactListFilters) {
        prefix = "Frank"
    }
    println("persons.filter = ${persons.filter(contactListFilters.getPredicate())}")

    val siteList = listOf(
            SiteVisit("/", 34.0, OS.WINDOWS),
            SiteVisit("/", 22.0, OS.MAC),
            SiteVisit("/login", 12.0, OS.WINDOWS),
            SiteVisit("/signup", 8.0, OS.IOS),
            SiteVisit("/", 16.3, OS.ANDROID)
    )

    println("siteList.filter { it.os == OS.WINDOWS }.map(SiteVisit::duration).average() = ${siteList.filter { it.os == OS.WINDOWS }.map(SiteVisit::duration).average()}")

    println("siteList.filter({ it.os in setOf<OS>(OS.IOS,OS.ANDROID)}).map(SiteVisit::duration).average() = ${siteList.filter({ it.os in setOf(OS.IOS, OS.ANDROID) }).map(SiteVisit::duration).average()}")

    println("siteList.averageDurationFor { it.os in setOf(OS.ANDROID,OS.IOS) } = ${siteList.averageDurationFor { it.os in setOf(OS.ANDROID, OS.IOS) }}")

//    The result is 5
//    The result is 6
//    The result is 0
//    filter = abcd
//    43
//    listOf = Alpha,Pris,Collars,Prado
//    listOf = ALPHA,PRIS,COLLARS,PRADO
//    getShippingCostCalculator(Delivery.EXPEDITED).invoke(Order(3)) = 12.3
//    persons.filter = [Person(name='Frank Underwood', age=56)]
//    siteList.filter { it.os == OS.WINDOWS }.map(SiteVisit::duration).average() = 23.0
//    siteList.filter({ it.os in setOf<OS>(OS.IOS,OS.ANDROID)}).map(SiteVisit::duration).average() = 12.15
//    siteList.averageDurationFor { it.os in setOf(OS.ANDROID,OS.IOS) } = 12.15
}

fun List<SiteVisit>.averageDurationFor(filter:(SiteVisit)->Boolean):Double{
    return this.filter(filter).map(SiteVisit::duration).average()
}

data class SiteVisit(
        val path:String,
        val duration:Double,
        val os: OS
)

enum class OS {
    WINDOWS, LINUX, MAC, IOS, ANDROID
}

class ContactListFilters {
    var prefix: String = ""
    var isYoung: Boolean = false

    fun getPredicate(): (Person) -> Boolean {
        val startWithPrefix = { person: Person -> person.name.startsWith(prefix) }
        if (!isYoung)
            return startWithPrefix
        return { startWithPrefix(it) && isYoung }
    }
}

enum class Delivery { STANDARD, EXPEDITED }

class Order(val itemCount: Int)

fun getShippingCostCalculator(delivery: Delivery): (Order) -> Double {
    if (delivery == Delivery.EXPEDITED) {
        return { 6 + 2.1 * it.itemCount }
    }
    return { 1.2 * it.itemCount }
}

fun <T> Collection<T>.joinToString(
        separator: String = ",",
        postfix: String = "",
        prefix: String = "",
        transformer: (T) -> String = { it.toString() }
): String {
    val stringBuffer = StringBuffer(prefix)
    if (isEmpty().not()) {
        for ((inxdex, t) in withIndex()) {
            if (inxdex > 0)
                stringBuffer.append(separator)
            stringBuffer.append(transformer(t))
        }
    }
    return stringBuffer.append(postfix).toString()
}

fun processTheAnswer(f: (Int) -> Int) {
    println(f(42))
}

fun String.filter(predicate: (Char) -> Boolean): String {
    val stringBuffer = StringBuffer()
    for (i in 0 until length) {
        val c = this[i]
        if (predicate(c))
            stringBuffer.append(c)
    }
    return stringBuffer.toString()
}

fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println("The result is $result")
}