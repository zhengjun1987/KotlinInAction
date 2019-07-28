package chapter02basis

import java.util.*

val string = "I am Kotlin"
val int = 1314
val long = 1314L
val float = 1.314f
val double: Double = 3.14
val double2 = 10.13e6
fun sum(x: Int, y: Int) = x + y

/*
* 此处必须声明函数返回类型，涉及到了递归
* 由于Kotlin支持子类型和继承，不能做到全局类型推导
* */
fun foo(n: Int):Int = if (n == 0) 1 else n * foo(n - 1)

fun main(args: Array<String>) {
    println("string = ${string}")
    println("string.javaClass = ${string.javaClass}")
    println("int = ${int}")
    println("int.javaClass = ${int.javaClass}")
    println("long = ${long}")
    println("long.javaClass = ${long.javaClass}")
    println("float = ${float}")
    println("float.javaClass = ${float.javaClass}")
    println("double = ${double}")
    println("double.javaClass = ${double.javaClass}")
    println("double2 = ${double2}")
    println("double2.javaClass = ${double2.javaClass}")

    println("sum(13,14) = ${sum(13, 14)}")
    println("sum(13,14) = ${sum(13, 14).javaClass}")

    for (i:Int in 1..12){
        println("foo(${i}}) = ${foo(i)}")
    }

    val x = intArrayOf(1, 2, 3, 4, 5)
    println("x = ${x}")
    println("Arrays.toString(x) = ${Arrays.toString(x)}")
//    x = intArrayOf(2,4,6)

    val book = Book(author = "Anonymous")
    book.printName()
    book.name = "Diving into Kotlin"
//    book.author = "Group"
    book.printName()

    val a :Int
    val random = Math.random()
    println("random = ${random}")
    a = if (random > 0.5)  1 else 0
    println("a = ${a}")

    println("cal(x) = ${cal(x)}")

    bar(1)
}

fun bar(x: Int){
    fun double(x: Int) = x *2
    println("double(x) = ${double(x)}")
}
fun cal(list:IntArray):Int {
    var res = 0
    for (element in list) {
        res *= element
        res += element
    }
    return res
}

class Book(var name:String = "Effective Java",val author:String){
    fun printName(){
        println("name = ${name}, author = ${author}")
    }

    override fun toString(): String {
        return "Book(name='$name', author='$author')"
    }
}