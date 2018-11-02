package chapter05lambda

import java.awt.Button
import java.awt.event.ActionListener
import java.io.File

class Person(val name: String, val age: Int) {
    override fun toString(): String {
        return "Person(name='$name', age=$age)"
    }
}

fun printMessagesWithPrefix(messages: Collection<String>, prefix: String) {
    messages.forEach { println("$prefix $it") }
}

fun printProblemCounts(responses: Collection<String>) {
    var clientError = 0
    var serverError = 0
    responses.forEach {
        if (it.startsWith("4"))
            clientError++
        else if (it.startsWith("5"))
            serverError++
    }
    println("clientError = $clientError serverError = $serverError")
}

fun tryToCountButtonClicks(button: Button): Int {
    var clicks = 0
    button.addActionListener {
        clicks++
    }
    return clicks
}

class Clerk(val name: String, val age: Int) {
    override fun toString(): String {
        return "Clerk(name='$name', age=$age)"
    }
}

fun main(args: Array<String>) {
//    val button = Button()
//    button.addActionListener { println("<top>.actionPerformed") }
    val list = listOf(Person("Alice", 29), Person("Bob", 31), Person("Frank", 43), Person(name = "ZhengJun", age = 31))
    println("list.maxBy { it.age } = ${list.maxBy { it.age }}")
    println("list.maxBy(Person::name) = ${list.maxBy(Person::name)}")

    val block = { println("Hello,Lambda!") }
    println("block = ${block.javaClass}")
    run(block)

    println("list.joinToString(separator = \" \"){p:Person -> p.name} = ${list.joinToString(separator = " ") { p: Person -> p.name }}")

    val listOf = listOf("403 Forbidden", "404 Not Found")
    printMessagesWithPrefix(listOf, "Error:")

    val responses = kotlin.collections.listOf("200 OK", "418 I'm a teapot", "500 Server Internal Error")
    printProblemCounts(responses)

    println("list.minBy(Person::age) = ${list.minBy(Person::age)}")
    println("list.minBy(Person::name)} = ${list.minBy(Person::name)}}")
    val maxBy = list.maxBy(Person::age)
    println("list.maxBy(Person::age) = $maxBy")
    println("list.maxBy(Person::name) = ${list.maxBy(Person::name)}")

    run(::salute)

    val createClerk = ::Clerk
    val clerk = createClerk("Alexander", 29)
    println("clerk = $clerk")

    val isClerkAdult = Clerk::isAdult
    println("isClerkAdult(clerk) = ${isClerkAdult(clerk)}")

    val intList = kotlin.collections.listOf(1, 2, 3, 4, 5, 6)
    println("intList.filter{ it % 2 == 0 } = ${intList.filter { it % 2 == 0 }}")

    println("list.filter{ it.age > 30 } = ${list.filter { it.age > 30 }}")

    println("intList.map{ it*it } = ${intList.map { it * it }}")

    println(list.map { "Dear ${it.name}\n    I\'m looking forword to your arrival.\n\n" }.joinToString("", "", ""))

    println("年龄大于三十的人的名单：" + list.asSequence().filter { it.age > 30 }.map(Person::name).toList())

    println("年龄最大的人的名字：" + list.filter { it === maxBy }.map { it.name })

    val map = mapOf(0 to "Zero", 1 to "One")
    val mapValues = map.mapValues { it.value.toUpperCase() }
    println("mapValues = $mapValues")

    val canBeInClub27 = { person: Person -> person.age <= 27 }
    println("list.filter(canBeInClub27) = ${list.filter(canBeInClub27)}")
    println("list.all(canBeInClub27) = ${list.all(canBeInClub27)}")
    println("list.any(canBeInClub27) = ${list.any(canBeInClub27)}")
    println("list.count(canBeInClub27) = ${list.count(canBeInClub27)}")
    println("list.find(canBeInClub27) = ${list.find(canBeInClub27)}")

    val canBeInClub30 = { person: Person -> person.age >= 30 }
    println("list.filter(canBeInClub30) = ${list.filter(canBeInClub30)}")
    println("list.all(canBeInClub30) = ${list.all(canBeInClub30)}")
    println("list.any(canBeInClub30) = ${list.any(canBeInClub30)}")
    println("list.count(canBeInClub30) = ${list.count(canBeInClub30)}")
    println("list.find(canBeInClub30) = ${list.find(canBeInClub30)}")

    println("list.groupBy(Person::age) = ${list.groupBy(Person::age)}")

    val letters = listOf("a", "ab", "b")
    println("letters.groupBy(String::first) = ${letters.groupBy(String::first)}")
    println("letters.groupBy(String::last) = ${letters.groupBy(String::last)}")

    val books = kotlin.collections.listOf(
            Book("红楼梦", listOf("曹雪芹", "高鹗")),
            Book("水浒传", listOf("罗贯中", "施耐庵")),
            Book("天龙八部", listOf("金庸", "倪匡")),
            Book("无证之罪", listOf("紫金陈"))
    )

    val flatMap = books.flatMap { it.authors }
    println("flatMap = ${flatMap.javaClass.canonicalName}")
    println("flatMap = $flatMap")

    println("books.flatMap(Book::authors) = ${books.flatMap(Book::authors)}")
    println("books.flatMap(Book::name) = ${books.flatMap { it.name.asIterable() }}")

    println("listOf(\"abc\",\"def\").flatMap(String::toList) = ${listOf("abc", "def").flatMap(String::toList)}")

    println("books.map(Book::authors).flatten() = ${books.map(Book::authors).flatten()}")

    val sequence = books.asSequence().map { println("map = $it");it.authors }.filter { println("filter = $it");it.size > 1 }
    println("sequence = ${sequence.javaClass.canonicalName}")
    println("sequence = ${sequence.flatten().toList()}")

    val ub = kotlin.collections.listOf(1, 2, 3, 4)

    intList.asSequence()
            .map { print("map($it) ");it * it }
            .filter { print("filter($it) "); it % 2 == 0 }
    println("=======================================================")
    intList.asSequence()
            .map { print("map($it) ");it * it }
            .filter { print("filter($it) "); it % 2 == 0 }
            .toList()
    println()
    println("=======================================================")
    intList.asSequence()
            .filter { print("filter($it) "); it % 2 == 0 }
            .map { print("map($it) ");it * it }
            .toList()
    println()
    println("=======================================================")
    intList.map { print("map($it) ");it * it }
            .filter { print("filter($it) "); it % 2 == 0 }
            .toList()
    println()
    println("=======================================================")

    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 99 }
    println("numbersTo100 = ${numbersTo100.sum()}")

    println("File() = ${File("C:\\Users\\Administrator\\IdeaProjects\\KotlinInAction\\.idea\\libraries\\KotlinJavaRuntime__2_.xml").isInsideHiddenDirectory()}")
    println(File("C:\\").isHidden)
    println(File("C:\\Users\\Administrator\\IdeaProjects\\KotlinInAction\\.idea").isHidden)

    val button = Button()
    button.addActionListener { println("it = $it") }

    val listener = ActionListener { view ->
        when (view.id) {
            3006 -> {
            }
            else -> {
            }
        }
    }

    println("alphabet() = ${alphabet()}")
    println("alphabet1() = ${alphabet1()}")
    println("alphabet2() = ${alphabet2()}")
    println("alphabet3() = ${alphabet3()}")
}

fun alphabet(): String {
    val stringBuffer = StringBuffer()
    return with(stringBuffer) {
        for (c in 'A'..'Z') {
            append(c)
        }
        append("\nNow I know the alphabet!")
        toString()
    }
}

fun alphabet1(): String = with(StringBuffer()) {
    for (c in 'A'..'Z') {
        append(c)
    }
    append("\nNow I know the alphabet!")
    toString()
}

fun alphabet2():String = StringBuffer().apply{
    for (c in 'A'..'Z') {
        append(c)
    }
    append("\nNow I know the alphabet!")
}.toString()

fun alphabet3():String = buildString {
    for (c in 'A'..'Z') {
        append(c)
    }
    append("\nNow I know the alphabet!")
}

fun File.isInsideHiddenDirectory() = generateSequence(this) { println("file = ${it.absolutePath}");it.parentFile }.find { it.isRooted }

class Book(val name: String, val authors: List<String>)

fun salute() {
    println("Salute!")
}

fun Clerk.isAdult() = age >= 18

//
//        list.maxBy { it.age } = Person(name='Frank', age=43)
//        list.maxBy(Person::name) = Person(name='ZhengJun', age=31)
//        block = class chapter05lambda.ClassesKt$main$block$1
//        Hello,Lambda!
//        list.joinToString(separator = " "){p:Person -> p.name} = Alice Bob Frank ZhengJun
//        Error: 403 Forbidden
//        Error: 404 Not Found
//        clientError = 1 serverError = 1
//        list.minBy(Person::age) = Person(name='Alice', age=29)
//        list.minBy(Person::name)} = Person(name='Alice', age=29)}
//        list.maxBy(Person::age) = Person(name='Frank', age=43)
//        list.maxBy(Person::name) = Person(name='ZhengJun', age=31)
//        Salute!
//        clerk = Clerk(name='Alexander', age=29)
//        isClerkAdult(clerk) = true
//        intList.filter{ it % 2 == 0 } = [2, 4, 6]
//        list.filter{ it.age > 30 } = [Person(name='Bob', age=31), Person(name='Frank', age=43), Person(name='ZhengJun', age=31)]
//        intList.map{ it*it } = [1, 4, 9, 16, 25, 36]
//        Dear Alice
//        I'm looking forword to your arrival.
//
//        Dear Bob
//        I'm looking forword to your arrival.
//
//        Dear Frank
//        I'm looking forword to your arrival.
//
//        Dear ZhengJun
//        I'm looking forword to your arrival.
//
//
//        年龄大于三十的人的名单：[Bob, Frank, ZhengJun]
//        年龄最大的人的名字：[Frank]
//        mapValues = {0=ZERO, 1=ONE}
//        list.filter(canBeInClub27) = []
//        list.all(canBeInClub27) = false
//        list.any(canBeInClub27) = false
//        list.count(canBeInClub27) = 0
//        list.find(canBeInClub27) = null
//        list.filter(canBeInClub30) = [Person(name='Bob', age=31), Person(name='Frank', age=43), Person(name='ZhengJun', age=31)]
//        list.all(canBeInClub30) = false
//        list.any(canBeInClub30) = true
//        list.count(canBeInClub30) = 3
//        list.find(canBeInClub30) = Person(name='Bob', age=31)
//        list.groupBy(Person::age) = {29=[Person(name='Alice', age=29)], 31=[Person(name='Bob', age=31), Person(name='ZhengJun', age=31)], 43=[Person(name='Frank', age=43)]}
//        letters.groupBy(String::first) = {a=[a, ab], b=[b]}
//        letters.groupBy(String::last) = {a=[a], b=[ab, b]}
//        flatMap = java.util.ArrayList
//        flatMap = [曹雪芹, 高鹗, 罗贯中, 施耐庵, 金庸, 倪匡, 紫金陈]
//        books.flatMap(Book::authors) = [曹雪芹, 高鹗, 罗贯中, 施耐庵, 金庸, 倪匡, 紫金陈]
//        books.flatMap(Book::name) = [红, 楼, 梦, 水, 浒, 传, 天, 龙, 八, 部, 无, 证, 之, 罪]
//        listOf("abc","def").flatMap(String::toList) = [a, b, c, d, e, f]
//        books.map(Book::authors).flatten() = [曹雪芹, 高鹗, 罗贯中, 施耐庵, 金庸, 倪匡, 紫金陈]
//        sequence = kotlin.sequences.FilteringSequence
//        map = chapter05lambda.Book@4769b07b
//        filter = [曹雪芹, 高鹗]
//        map = chapter05lambda.Book@cc34f4d
//        filter = [罗贯中, 施耐庵]
//        map = chapter05lambda.Book@17a7cec2
//        filter = [金庸, 倪匡]
//        map = chapter05lambda.Book@65b3120a
//        filter = [紫金陈]
//        sequence = [曹雪芹, 高鹗, 罗贯中, 施耐庵, 金庸, 倪匡]
//        =======================================================
//        map(1) filter(1) map(2) filter(4) map(3) filter(9) map(4) filter(16) map(5) filter(25) map(6) filter(36)
//        =======================================================
//        filter(1) filter(2) map(2) filter(3) filter(4) map(4) filter(5) filter(6) map(6)
//        =======================================================
//        map(1) map(2) map(3) map(4) map(5) map(6) filter(1) filter(4) filter(9) filter(16) filter(25) filter(36)
//        =======================================================
//        numbersTo100 = 4950
//        File() = C:\Users\Administrator\IdeaProjects\KotlinInAction\.idea\libraries\KotlinJavaRuntime__2_.xml
//        true
//        false
//        alphabet() = ABCDEFGHIJKLMNOPQRSTUVWXYZ
//        Now I know the alphabet!
//        alphabet1() = ABCDEFGHIJKLMNOPQRSTUVWXYZ
//        Now I know the alphabet!
//        alphabet2() = ABCDEFGHIJKLMNOPQRSTUVWXYZ
//        Now I know the alphabet!
//        alphabet3() = ABCDEFGHIJKLMNOPQRSTUVWXYZ
//        Now I know the alphabet!