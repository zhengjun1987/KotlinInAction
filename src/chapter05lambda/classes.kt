package chapter05lambda

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
}