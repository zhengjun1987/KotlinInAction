package chapter03functions.flyer

class Outer {
    val name = "inner class syntax"
    var inner:Inner = Inner()



    inner class Inner {
        fun printOutMember(){
            println("name = ${name}")
        }
    }
}

fun main() {
    val outer = Outer()
    outer.inner.printOutMember()
}