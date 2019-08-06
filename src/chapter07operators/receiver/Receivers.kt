package chapter07operators.receiver

open class Base
class Extended : Base()
open class X {
    open fun Base.foo() {
        println("X Base.foo")
    }

    open fun Extended.foo() {
        println("X Extended.foo")
    }

    fun deal(base: Base) {
        base.foo()
    }
}

class Y:X(){
    override fun Base.foo() {
        println("Y Base.foo")
    }

    override fun Extended.foo() {
        println("Y Extended.foo")
    }
}

fun main() {
    X().deal(Base())
    X().deal(Extended())
    Y().deal(Base())
    Y().deal(Extended())
}