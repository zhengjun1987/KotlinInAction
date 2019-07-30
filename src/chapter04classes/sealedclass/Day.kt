package chapter04classes.sealedclass

sealed class Day {
    class SUN : Day()
    class MON : Day()
    class TUE : Day()
    class WED : Day()
    class THU : Day()
    class FRI : Day()
    class SAT : Day()
}

fun schedule(day: Day) =
        when (day) {
            is Day.SUN -> "play"
            is DEC -> "snow"
            else -> "work"
        }

fun main() {
    println("schedule(DEC()) = ${schedule(DEC())}")
    println("getArea(Square(5.6)) = ${getArea(Square(5.6))}")
}

class DEC : Day()

class Square(val margin: Double) : Shape.Rectangle(margin, margin)

sealed class Shape {
    class Circle(val radius: Double) : Shape()
    open class Rectangle(val width: Double, val height: Double) : Shape()
    class Triangle(val base: Double, val height: Double) : Shape()
}

fun getArea(shape: Shape): Double =
        when (shape) {
            is Shape.Circle -> Math.pow(shape.radius, 2.0) * Math.PI
            is Shape.Rectangle -> shape.height * shape.width
            is Shape.Triangle -> shape.height * shape.base / 2.0
        }

fun constantPattern(a: Int) =
        when (a) {
            1 -> "It is 1"
            2 -> "It is 2"
            else -> "some number else"
        }

fun logicPattern(a:Int)=
        when{
            a in 2..11 -> "${a.toString()} is smaller than 12 and greater than 1"
            else -> "Maybe $a is smaller than 2, or greater than 11"
        }

sealed class Expr {
    data class Num(val value:Int):Expr()
    data class Operator(val opName:String,val left:Expr, val right:Expr)
}