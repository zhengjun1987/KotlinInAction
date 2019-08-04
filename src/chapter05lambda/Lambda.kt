package chapter05lambda

import sun.net.www.http.HttpClient
import java.net.URL

val sum:Int.(Int) -> Int = {other -> plus(other)}

fun Int.add(other:Int) = plus(other)

data class Stu(val name:String,val age:Int,val sex:String,val score:Int){
    override fun toString(): String {
        return "Stu(name='$name')"
    }
}

fun main() {
    println("3.sum(5) = ${3.sum(5)}")
    println("3.add(5) = ${3.add(5)}")

    val httpClient = HttpClient(URL("https://www.zhihu.com"),null,1500)
    with(httpClient){
        setDoNotRetry(false)
        setIgnoreContinue(false)
    }

    httpClient.apply {
        setDoNotRetry(false)
        setIgnoreContinue(false)
    }

    val intRange = 1..10
    val map = intRange.map { it * 2 }
    println("map = ${map}")
    println("map.javaClass = ${map.javaClass}")

    val jilen = Stu("Jilen", 30, "m", 95)
    val shaw = Stu("Shaw", 18, "m", 90)
    val yison = Stu("Yison", 40, "f", 59)
    val pan = Stu("Pan", 36, "f", 55)
    val lisa = Stu("Lisa", 25, "f", 88)
    val jack = Stu("Jack", 30, "m", 70)

    val list = arrayListOf<Stu>(jilen, shaw, yison, pan, lisa, jack)
    val predicate: (Stu) -> Boolean = { it.sex == "m" }
    val maleList = list.filter(predicate)
    println("maleList = ${maleList}")
    println("list.count(predicate) = ${list.count(predicate)}")

    val sumBy = list.sumBy { it.score }
    println("list.sumBy { it.score } = $sumBy")

    println("map.sum() = ${map.sum()}")
    println("intRange.sum() = ${intRange.sum()}")

    println("map.fold(0) {acc: Int, i: Int -> acc + i } = ${map.fold(0) { acc: Int, i: Int -> acc + i }}")

    val reduce = intRange.reduce { acc, i ->
        println("acc = [${acc}], i = [${i}]")
        acc * i
    }
    println("reduce = ${reduce}")

    val groupBy = list.groupBy(Stu::sex)
    println("list.groupBy(Stu::sex) = $groupBy")

    val compondList = listOf(listOf(jilen,shaw,lisa), listOf(yison,pan), listOf(jack))
    println("compondList.flatten() = ${compondList.flatten()}")

    println("compondList.flatMap {it.map(Stu::name) = ${compondList.flatMap {it.map(Stu::name)}}")

}

