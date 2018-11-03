package chapter06types

/**
 *   Author:Zheng Jun
 *   E-mail:zhengjun1987@outlook.com
 *   Date:3/11/2018 20:35
 *   Project:KotlinInAction
 */

fun strLen(s: String) = s.length

fun strLenSafe(s: String?) = if (s != null) s.length else 0
fun strLen2(s: String?) = s?.length

fun printAllCaps(s:String?) {
    val upperCase = s?.toUpperCase()
    println(upperCase)
}

class Employee(val name:String,val manager:Employee?)

fun managerName(employee: Employee) = employee.manager?.name

fun main(args: Array<String>) {
    //Null can not be a value of a non-null type String
//    println("strLen(null) = ${strLen(null)}")
    println("strLen2(null) = ${strLen2(null)}")//strLen2(null) = null

    val s1: String? = null
    //Type mismatch
//    val s2:String = s1
    println("strLenSafe(null) = ${strLenSafe(null)}")
    println("strLenSafe(s1) = ${strLenSafe(s1)}")
    println("strLenSafe(\" abs \") = ${strLenSafe("abs")}")

    printAllCaps("abc")
    printAllCaps(null)

    val ceo = Employee("Da Boss", null)
    val developer = Employee("Bob Smith", ceo)
    println("managerName(ceo) = ${managerName(ceo)}")
    println("managerName(developer) = ${managerName(developer)}")
}