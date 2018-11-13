package chapter07operators

/**
 *   Author:Zheng Jun
 *   E-mail:zhengjun1987@outlook.com
 *   Date:13/11/2018 23:37
 *   Project:KotlinInAction
 */

class Person(val firstName:String,val lastName:String):Comparable<Person>{
    override fun compareTo(other: Person): Int {
        return compareValuesBy(this,other,Person::lastName,Person::firstName)
    }
}

fun main(args: Array<String>) {
    println("Point(10,20) == Point(10,20) = ${Point(10, 20) == Point(10, 20)}")
    println("Point(10,20) == Point(5,20) = ${Point(10, 20) == Point(5, 20)}")
    println("null == Point(5,20) = ${null == Point(5, 20)}")

    val alice = Person("Alice", "Smith")
    val bob = Person("Bob", "Johnson")
    println("alice < bob = ${alice < bob}")
}