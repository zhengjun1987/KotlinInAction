package chapter07operators

class Child : Parent() {
    override fun foo() {
        println("foo in class Child")
    }
}

open class Parent {
    open fun foo() {
        println("foo in class Parent")
        val child = Child()
        child.foo2()
    }

    fun Child.foo2() {
        this.foo()
//        this@Parent.foo()
    }
}

fun Parent.foor() = "I'm Parent.foo()"
fun Child.foor() = "I'm Child.foo()"

object Test {
    @JvmStatic
    fun main(args: Array<String>) {
        val parent = Parent()
//        val child = Child()
//        parent.foo2()
        parent.foo()

        testRun()
        testLet(null)
        testAlso("ALSO")
        "random".also {
            println("it = ${it}")
            println("this = ${this@Test}")
        }

        val let = Math.random().takeIf { it > 0.5 }?.let { it * 10 } ?: 0
        println("let = $let")

        val p :Parent = Child()
        val child = Child()
        println("p.foor() = ${p.foor()}")
        println("child.foor() = ${child.foor()}")
    }
}

fun testAlso(string: String?) {
    val also = string?.also {
        println("it = ${it}")
//        println("this = ${this@Test}")
    }
    println("also = ${also}")
}

fun testLet(string: String?) {
    val result = string?.let {
        println("it = ${it}")
        it.length
    } ?: 0
    println("result = ${result}")
}

/**
 *
 */
fun testRun() {
    val s = "Prefert"
    run {
        //        println("this = ${this}")
//        println("this@MultiThis = ${this@MultiThis}")
        val s = "Yaren"
        println("s = ${s}")
    }
    println("s = ${s}")
}