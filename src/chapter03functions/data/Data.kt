package chapter03functions.data

/**
 * Created by zhengjun
 * Date: 2019/7/29
 * Mail:zhengjun1987@outlook.com
 */

data class Bird(var weight:Double,var age:Int,var color:String)

fun main(args: Array<String>) {
    val bird = Bird(20.0, 1, "BLUE")
    val bird2:Bird = bird
    bird2.age = 2
    println("bird.age = ${bird.age}")//2

    val copy = bird.copy()
    copy.age = 3
    println("bird.age = ${bird.age}")

    var (weight,age,color) = copy//（若无自定义实现）根据主构造函数的顺序来解构
    println("weight = ${weight}")
    println("weight.javaClass = ${weight.javaClass}")
    println("age = ${age}")
    println("age.javaClass = ${age.javaClass}")
    println("color = ${color}");
    println("color.javaClass = ${color.javaClass}")

    val (weight1,age1,color1) = "20.0, 1, BLUE".split(",")
    println("weight1 = ${weight1}")
    println("weight1.javaClass = ${weight1.javaClass}")
    println("age1 = ${age1}")
    println("age1.javaClass = ${age1.javaClass}")
    println("color1 = ${color1}")
    println("color1.javaClass = ${color1.javaClass}")

    val pair = Pair(20.0, 1)
    val triple = Triple(20.0, 1, "BLUE")
    val (weightP,ageP) = pair
    val (weightT,ageT,colorT) = triple
    println("weightP = ${weightP}")
    println("ageP = ${ageP}")
    println("weightT = ${weightT}")
    println("ageT = ${ageT}")
    println("colorT = ${colorT}")
}