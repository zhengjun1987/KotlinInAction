package chapter03functions.flyer

interface Flyer {
    fun fly()
    fun kind() = "flying animals"
}

interface Animal {
    val name:String
    fun eat()
    fun kind() = "living creatures"
}

class Bird(override val name:String):Flyer,Animal {

    /*
    * 多重实现发生冲突时候的处理方法
    * */
    override fun kind()=super<Flyer>.kind()

    override fun fly() {
        println("I can fly")
    }

    override fun eat() {
        println("I can eat")
    }
}