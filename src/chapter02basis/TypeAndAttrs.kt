package chapter02basis

import java.util.*

/**
 *   Author:Zheng Jun
 *   E-mail:zhengjun1987@outlook.com
 *   Date:2018/5/28 23:47
 *   Project:KotlinInAction
 */

public class Person {
    private val name: String

    constructor(name: String) {
        this.name = name
    }



    fun getName(): String = name
}

class Person2(
        val name: String,
        var isMarried: Boolean
)

fun main(args: Array<String>) {
//    val person = Person2("Bob", true)
    var person2 = Person2(isMarried = false, name = "Alex")
    println("person2 = ${person2.name}")
//    person2 = chapter02basis.Person2@2f410acf  //默认的toString方法没有复写
    println("person2.name = ${person2.name}")
//    person2.name = Alex
    println("person2.isMarried = ${person2.isMarried}")
//    person2.isMarried = false
    person2.isMarried = true
    println("person2.isMarried = ${person2.isMarried}")
//    person2.isMarried = true


    val rect = Rectangle(13,13)
    rect.tag = "silence"
    println("rect = ${rect}")
    rect.width = 12
    println("rect = ${rect}")// 由于tag变量的get属性已经被写死，所以无法显示其真正的值
    rect.showTag()
    println("rect.isSquare = ${rect.isSquare}")
    println("rect.tag = ${rect.tag}")

    val createRandomRectangle = createRandomRectangle()
    println("createRandomRectangle = $createRandomRectangle")
}

class Rectangle(val height: Int, var width: Int) {
    val isSquare: Boolean
        get() {
            return width == height
        }

    var tag : String=""
        get() {
            print("get ")
            return "immutable"}

    fun showTag(): Void? {
        println("tag = $tag")
        return null
    }

    override fun toString(): String {
        return "Rectangle(height=$height, width=$width, isSquare=$isSquare, tag=$tag)"
    }
}

fun createRandomRectangle():Rectangle {
    val random = Random()
    return Rectangle(width = random.nextInt(100),height = random.nextInt(100))
}