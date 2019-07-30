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
    when (day){
        is Day.SUN -> "play"
        is DEC -> "snow"
        else -> "work"
}

fun main() {
    println("schedule(DEC()) = ${schedule(DEC())}")
}

class DEC : Day()

sealed class Shape {
    class Circle(val radius:Double):Shape()
    class Rectangle(val width:Double,val height:Double): Shape()
    class Triangle(val base:Double,val height:Double): Shape()
}

fun getArea(shape: Shape) : Double =
        when (shape){
            is Shape.Circle -> Math.pow(shape.radius,2.0)*Math.PI
            is Shape.Rectangle -> shape.height * shape.width
            is Shape.Triangle -> shape.height * shape.base / 2.0
        }