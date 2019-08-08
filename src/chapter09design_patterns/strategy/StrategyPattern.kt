package chapter09design_patterns.strategy

interface SwimStrategy {
    fun swim()
}

class BreastSwim : SwimStrategy {
    override fun swim() {
        println("I'm breast stroking.")
    }
}

open class BackSwim : SwimStrategy {
    override fun swim() {
        println("I'm back stroking.")
    }
}

class FreeSwim : SwimStrategy {
    override fun swim() {
        println("I'm free stroking.")
    }
}

class Swimmer(var strategy: () -> Unit) {
    fun swim() {
        strategy()
    }
}

object Butterfly : BackSwim() {
    override fun swim() {
        println("I'm swimming like a butterfly.")
    }
}

fun swimBreast() {
    println("I'm breast stroking.")
}

fun swimFree() {
    println("I'm free stroking.")
}

fun Swimmer.swimming(style: SwimStrategy) {
    this.strategy = { style.swim() }
    this.swim()
}

fun main(args: Array<String>) {
//    val swimmer = Swimmer(FreeSwim())
//    swimmer.swim()
//    swimmer.strategy = BreastSwim()
//    swimmer.swim()

    val swimmer = Swimmer(::swimBreast)
    swimmer.swim()
    swimmer.strategy = ::swimFree
    println("::swimBreast::class = ${::swimBreast::class}")
    println("::swimFree::class = ${::swimFree::class}")
    swimmer.swim()

    swimmer.swimming(Butterfly)
    swimmer.swimming(BackSwim())
}