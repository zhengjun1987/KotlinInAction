package chapter05lambda

abstract class Animal(val weight: Double)

class Bird(weight: Double, val flightSpeed: Double) : Animal(weight), ICanFly, ICanBuildNest

class Fish(weight: Double, val swimmingSpeed: Double) : Animal(weight)

interface ICanFly

interface ICanBuildNest

class SmartList<T> : ArrayList<T>() {
    fun find(t: T): T? {
        val i = indexOf(t)
        return if (i >= 0) get(i) else null
    }
}

interface Ground

open class Plate<T>(val t: T)

open class Fruit(val weight: Double)

class Apple(weight: Double):Fruit(weight)

class Banana(weight: Double):Fruit(weight)

class FruitPlate<F:Fruit>(t: F):Plate<F>(t)

class Noodles(weight: Double)

class Watermelon(weight: Double):Fruit(weight),Ground

fun <T> cut(t: T) where T:Fruit,T:Ground {
    println("You can cut me")
}

//fun <T:(Fruit,Ground)> cut2(t: T){
//    println("Cut $t")
//}

fun main() {
    //具体实现类型
    var f: Animal = Bird(weight = 0.1, flightSpeed = 10.0)
    f = Fish(weight = 0.25, swimmingSpeed = 10.0)

    val b = Bird(0.1, 10.0)
    val c: Animal = b
    val n2: Bird? = c as? Bird

    val smartList = SmartList<String>()
    smartList.add("one")
    println("smartList.find(\"one\") = ${smartList.find("one")}")
    println("smartList.find(\"two\").isNullOrEmpty() = ${smartList.find("two").isNullOrEmpty()}")

    val fruitPlate = FruitPlate(Apple(10.0))
//    val plate = FruitPlate(Noodles(5.0)) Type mismatch

    cut(Watermelon(1.0))
//    cut(Apple(0.5)) Type mismatch
//    cut2<Apple,Apple>(Apple(0.5))
//    cut2<Watermelon,Watermelon>(Watermelon(1.0))

    val ints = arrayOf(1, 2, 3)
    val list = arrayListOf<Int>(1, 2, 3)
    println("ints.javaClass = ${ints.javaClass}")
    println("list.javaClass = ${list::class}")
    println("list.get(0).javaClass = ${list.get(0)::class.java}")

    println("list::class.java::getGenericSuperclass = ${list::class.java.javaClass}")

    val appleArray = arrayOfNulls<Apple>(3)
//    val anyArray:Array<Any?> = appleArray
}