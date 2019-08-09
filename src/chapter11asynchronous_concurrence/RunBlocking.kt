package chapter11asynchronous_concurrence

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking {
    launch {
        kotlinx.coroutines.delay(1000)
        println("World")
        println("Hello-${Thread.currentThread().name}")
    }
    println("Hello-${Thread.currentThread().name}")
    print("Hello,")
    kotlinx.coroutines.delay(2000)
}