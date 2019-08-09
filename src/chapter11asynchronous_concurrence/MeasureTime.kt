package chapter11asynchronous_concurrence

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) = runBlocking {
    var millis = measureTimeMillis {
        val searchItem1 = searchItem1()
        val searchItem2 = searchItem2()
        PrintUtils.print("The items are $searchItem1 and $searchItem2\n")
    }
    PrintUtils.print("Direct invoke cost time $millis\n")
    millis = measureTimeMillis {
        val item1 = async { searchItem1() }
        val item2 = async { searchItem2() }
        PrintUtils.print("The items are ${item1} and ${item2}\n")
        PrintUtils.print("The items are ${item1.await()} and ${item2.await()}\n")
    }
    PrintUtils.print("Async invoke cost time $millis")
}