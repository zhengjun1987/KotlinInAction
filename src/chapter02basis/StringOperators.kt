package chapter02basis

/**
 * Created by zhengjun
 * Date: 2019/7/28
 * Mail:zhengjun1987@outlook.com
 */

fun main(args: Array<String>) {
    val s = "hello, world!"
    println("s.length = ${s.length}")
    println("s.substring(0,5) = ${s.substring(0, 5)}")
    println("s = ${s}")

    for (c in s.toUpperCase()) {
        print(c)
    }

    println()

    println("s[0] = ${s[0]}")
    println("s.first() = ${s.first()}")
    println("s.last() = ${s.last()}")

    println("\"\".isEmpty() = ${"".isEmpty()}")
    println("\"\".isBlank() = ${"".isBlank()}")
    println("\" \".isEmpty() = ${" ".isEmpty()}")
    println("\" \".isBlank() = ${" ".isBlank()}")

    val rawString = """<html>
Kotlin is awesome.
        Kotlin is a better Java.
</html>
    """
    println(rawString)

    message("Shaw","Kotlin")

    val a = "Java"
    val b = "Java"
    val c = "Kotlin"
    val d = "Kot"
    val e = "lin"
    val f = d + e
    println("a == b = ${a == b}")//结构相等
    println("a === b = ${a === b}")//指针引用相等
    println("c == f = ${c == f}")//结构内容相等
    println("c === f = ${c === f}")//指针引用相等
}

fun message(name:String,lang:String){
    println("Hi, ${name}, welcome to ${lang}")}