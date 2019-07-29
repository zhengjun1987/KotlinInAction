package chapter03functions.delegate

/**
 * Created by zhengjun
 * Date: 2019/7/29
 * Mail:zhengjun1987@outlook.com
 */

interface CanFly {
    fun fly()
}

interface CanEat {
    fun eat()
}

open class Flyer:CanFly{
    override fun fly() {
        println("I can fly")
    }
}

open class Animal:CanEat {
    override fun eat() {
        println("I can eat")
    }
}

class Bird(flyer: Flyer,animal: Animal):CanFly by flyer,CanEat by animal

fun main(args: Array<String>) {
    val bird = Bird(Flyer(), Animal())
    bird.eat()
    bird.fly()
}