package chapter07operators

import chapter07operators.Son.Companion.age

/*
* 多态的类型：
*   1.子类型多态 —— 子类继承重写
*   2.参数多态 —— 最常见的参数多态实例就是泛型
*       声明和定义 函数、复合类型与变量 的时候不指定其具体类型；而是把这部分类型作为参数使用 —— 使得该声明定义对各种类型均适用
*   3.特设多态
* */

fun main(args: Array<String>) {
    test(ClassA("sdKHEWTIu"))
    test(ClassB("utgkewJYU"))
    println("Area(1.0) + Area(2.0) = ${Area(1.0) + Area(2.0)}")
    println("Area(3.0)[\"v\"] = ${Area(3.0)["v"]}")
    val mutableList = mutableListOf(1, 2, 4)
    println("mutableList = ${mutableList}")
    mutableList.exchange(0,2)
    println("mutableList = ${mutableList}")
    println("mutableList.sumIsEven = ${mutableList.sumIsEven}")
    Son.bar()
    val son = Son()
    son.foo()
    son.test()
}

class Son {
    companion object {
        val age = 10
    }

    fun test() = println("son called member test")
}

/*
* 相同名称的类成员方法优先级高于扩展方法
* */
fun Son.test() = println("son called extension test")

fun Son.Companion.bar(){
    println("<top>.bar")
    println("age = $age")
}

fun Son.foo(){
    println("<top>.foo")
    println("age = $age")
}

val MutableList<Int>.sumIsEven:Boolean
    get() = this.sum() % 2 == 1

fun <T> MutableList<T>.exchange(fromIndex:Int,toIndex:Int){
    val temp = get(fromIndex)
    set(fromIndex,get(toIndex))
    set(toIndex,temp)
}

interface KeyI {
    val uniqueKey: String
}

class ClassA(override val uniqueKey: String) : KeyI

class ClassB(override val uniqueKey: String) : KeyI

fun <T : KeyI> test(t: T) {
    println("t.uniqueKey = ${t.uniqueKey}")
}

fun String.isEmpty(): Boolean = this.trim().equals("")

/*
* 自定义的可以进行加总运算的类接口
* */
interface Summable<T : Summable<T>> {
    fun plusThat(that: T): T
}

/*
* 具体类实现上述接口
* */
data class Lens(val v:Int):Summable<Lens>{
    override fun plusThat(that: Lens): Lens {
        return Lens(this.v + that.v)
    }
}

data class Area(val value:Double)

/*
* operator关键字 —— 将一个函数标记为复写一个操作符或者实现的一个约定
* 函数名称plus是Kotlin内置规定的函数名（plus、minus、times、div、mod...）
* */
operator fun Area.plus(that:Area) = Area(this.value + that.value)

operator fun Area.get(string: String):Double = this.value