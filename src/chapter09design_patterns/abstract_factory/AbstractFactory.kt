package chapter09design_patterns.abstract_factory

import java.lang.IllegalArgumentException

interface Computer
class Dell : Computer
class Asus : Computer
class Acer : Computer

abstract class AbstractFactory {
    abstract fun produce(): Computer

    companion object {
        inline operator fun <reified T : Computer> invoke(): AbstractFactory =
                when (T::class) {
                    Dell::class -> DellFactory()
                    Asus::class -> AsusFactory()
                    Acer::class -> AcerFactory()
                    else -> throw IllegalArgumentException()
                }

    }
}

class DellFactory : AbstractFactory() {
    override fun produce(): Computer {
        return Dell()
    }
}

class AsusFactory : AbstractFactory() {
    override fun produce(): Computer {
        return Asus()
    }
}

class AcerFactory : AbstractFactory() {
    override fun produce(): Computer {
        return Acer()
    }
}

fun main(args: Array<String>) {
    val factory = AbstractFactory<Dell>()
    val computer = factory.produce()
    println("computer = ${computer}")
}