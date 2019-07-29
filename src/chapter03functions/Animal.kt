package chapter03functions

abstract class Animal {
    abstract fun run()
}

open class Horse():Animal(){
    override fun run() {
        println("Runs very fast!")
    }
}

open class Donkey():Animal(){
    override fun run() {
        println("runs very slow!")
    }
}

class Mule():Horse(){
    override fun run() {
        super.run()
    }
}