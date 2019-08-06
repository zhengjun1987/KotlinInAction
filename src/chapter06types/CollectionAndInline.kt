package chapter06types

/**
 * Created by zhengjun
 * Date: 2019/8/4
 * Mail:zhengjun1987@outlook.com
 */

fun main(args: Array<String>) {
    var list: List<Int> = listOf(1, 2, 3, 4, 4, 5, 4, 5)
    println("list = ${list}")
    val set = setOf(1, 2, 3, 4, 4, 5, 4)
    println("set = ${set}")
    val map = mapOf(1 to 1, 2 to 2, 2 to 4)
    println("map = ${map}")

//    list[0] = 0 只读集合中没有set方法
    list = mutableListOf(1, 2, 3, 4, 4, 5, 4, 5)
    list[0] = 0
    println("list = ${list}")

    val listOf = listOf(1, 3, 5, 7, 9)
    listOf.let { println("it = ${it}") }
    listOf.apply { println("this = ${this}") }
    with(listOf) { println("this = ${this}") }

    //惰性集合
//    val intRange = 1..10000
    /*
    * 这种写法只适合在集合数据较少的时候
    * 集合数量一旦过大(比如超过10万)，每个诸如filter、map的操作都会产生临时的集合对象占用内存，很容易出现OOM问题
    * */
//    val result = intRange.filter { it % 2 == 1 }.map { it * 2 }

    /*
    * 先将集合转换成序列，很大程度上提高了集合操作的效率
    * 序列在进行filter、map等操作时，并不会产生临时的集合对象，减少内存开销
    *
    * 惰性求值（LAZY EVALUATION）：一种在需要时才进行计算的求值方式
    *
    * 优点：
    * 1.性能上的提升
    * 2.可以构造出一个无限的数据类型
    *
    * 序列的操作分为两类：
    * 1.中间操作：filter、map之类的 —— 每次中间操作返回的都是一个序列，并不执行其中的计算
    * 2.末端操作：toList —— 末端操作才是实际触发计算的操作
    *
    * 序列操作与普通集合操作的区别：
    *   普通集合操作会针对原集合的每个元素逐一进行每个操作，最后将结果进行集合
    *   序列操作针对的是每个操作，将原集合针对每个操作计算完之后再进行下一个操作符进行计算
    * */
//    val lazyResult = intRange.asSequence().filter { it % 2 == 1 }.map { it * 2 }.toList()


    /*
    * 产生无限数列的方法
    * */
    val infiniteSequence = generateSequence(0) { it + 1 }
    println("infiniteSequence.take(9).toList() = ${infiniteSequence.take(9).toList()}")

    /*
    * Kotlin序列 与 Java 8 Stream的对比
    *   1.Java也可以使用函数风格的API，也有惰性求值特性
    *   2.Stream是一次性的（运用.stream（）方法创建的流是一次性使用的，类似于iterator，消耗掉之后就不能再用了，必须另外重建）
    *   3.Stream能够并行处理数据 —— Java 8 Stream能够在多核架构上并行地进行流操作，而Kotlin还没有实现
    * */

    /*
    * 内联函数
    *   Kotlin大量使用Lambda，使我们对集合的操作优雅了很多 —— 代价就是会带来额外的开销
    *   Kotlin的内联函数的设计初衷是为了优化Lambda带来的额外开销，而在Java中我们无需关注这个问题，Java 7之后JVM引入了invokedynamic技术自动优化Lambda
    *
    *   invokedynamic —— 在运行期才产生相应的翻译代码
    *   被首次调用的时候才产生一个匿名类来替换中间代码，后续的调用会直接使用上述匿名类
    *   优点：
    *       1.具体的转换实现在运行时才进行，需要静态生成的类的个数及字节码大小都大幅减少
    *       2.把实际的翻译策略隐藏到JDK库，确保后向兼容的同时提高了灵活性
    *       3.JVM天然支持对Lambda的优化，开发者在使用Lambda时无需考虑该问题，极大提升了开发者的体验
    *
    *   Kotlin内联函数存在的原因
    *       Kotlin在最初必须兼容Android最主流的Java版本SE 6
    *       Java SE 6至今仍然是Android开发的主流语言
    *   使用inline关键字修饰函数，其函数体在编译期被嵌入每个被调用的地方，以减少额外生成的匿名类数量和函数执行的时间开销
    * */
    foo({ println("Diving into Kotlin...") }, { println("I'm not inlined") })
    getType<Int>()
    bat { println("return deleted"); return }
    println("To see if I'm executed")

    /*
    * 内联函数不是万能的
    *   1.JVM对普通的函数已经能够根据实际情况智能判断是否进行内联优化
    *   2.尽量避免对体量大的函数进行内联
    *   3.函数被内联后无法获取闭包内的私有成员，除非声明为internal
    * */
}

inline fun <reified T> getType() {
    println(T::class.java)
}

/*
* 部分内联函数带有return语句，其Lambda参数常常来自上下文其他地方
* 用crossinline关键字修饰参数，检查是否有错误发生
* */
inline fun bat(/*crossinline*/ function: () -> Unit) {
    println("before local return...")
    function()
    println("after local return...")
    return
}

/*
* noinline关键字可以使函数参数中的被修饰参数不被内联
* */
inline fun foo(block: () -> Unit, noinline block2: () -> Unit) {
    println("before block ...")
    block.invoke()
    block2()
    println("after block ...")
}