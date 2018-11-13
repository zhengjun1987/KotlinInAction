package chapter07operators

/**
 *   Author:Zheng Jun
 *   E-mail:zhengjun1987@outlook.com
 *   Date:10/11/2018 01:05
 *   Project:KotlinInAction
 */

data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }

    /**
     * 這個equals方法為什麼不能定義為operator？？？
     * 也不能寫作Point類的擴展方法？？？
     *
     * 因為繼承自Any類的方法始終要優先於擴展方法
     * */
    override fun equals(other: Any?): Boolean {
        //Kotlin中 === 才是比較引用對象的地址，不能被重載
        if (other === this) return true
        if (other !is Point) return false
        return x == other.x && y == other.y
    }
}

operator fun Point.times(scale: Double): Point {
    return Point((x * scale).toInt(), (y * scale).toInt())
}

operator fun Char.times(count: Int): String {
    return toString().repeat(count)
}

fun main(args: Array<String>) {
    val point1 = Point(10, 20)
    val point2 = Point(30, 40)
    println("point1 + point2 = ${point1 + point2}")

    println("point1.times(1.5) = ${point1.times(1.5)}")

    println("point1 * 1.5 = ${point1 * 1.5}")

    println('A' * 5)

    println("6 and 1 = ${6 and 1}")
    println("6 or 1 = ${6 or 1}")
    println("1 shl 4 = ${1 shl 4}")

    var point = Point(1, 2)
    println("point = $point")
    point += Point(2, 4)
    println("point = $point")
    point *= 5.0//Kotlin的乘法运算符重载不支持交换律，需要的话必须另外自己重写扩展方法
    println("point = $point")

    val arrayList = arrayListOf(1, 2, 3)
    println("arrayList = $arrayList")
//    @kotlin.internal.InlineOnly
//    public inline operator fun <T> MutableCollection<in T>.plusAssign(element: T) {
//        this.add(element)
//    }
    arrayList += 4
    println("arrayList = $arrayList")
    arrayList += 4
    println("arrayList = $arrayList")
    arrayList += arrayListOf(5, 6)
    println("arrayList = $arrayList")
}