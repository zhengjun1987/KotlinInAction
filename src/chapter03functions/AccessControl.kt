package chapter03functions

/**
 * Created by zhengjun
 * Date: 2019/7/28
 * Mail:zhengjun1987@outlook.com
 */


sealed class Birdy(){
    //父类的方法默认final，要允许重写的话必须指定open
    open fun fly(miles:Int){
        println("I can fly $miles daily!")
    }
}

open class Penguin:Birdy(){
    override fun fly(miles: Int){
        println("We cannot fly actually!")
    }
}

class EmperiorPeguin:Penguin(){
    override fun fly(miles: Int) {
        super.fly(miles)
        println("Nether do I.")
    }
}

fun main(args: Array<String>) {
    val emperiorPeguin = EmperiorPeguin()
    emperiorPeguin.fly(2)
}