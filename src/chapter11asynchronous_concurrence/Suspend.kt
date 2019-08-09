package chapter11asynchronous_concurrence

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

suspend fun searchItem1():String{
    delay(500)
    PrintUtils.print("searchItem1 --\n")
    return "ItemOne"
}

suspend fun searchItem2():String{
    delay(500)
    PrintUtils.print("searchItem2 --\n")
    return "ItemTwo"
}

fun main(args: Array<String>) = runBlocking {
//    val item1 = searchItem1()
//    val item2 = searchItem2()
    val item1 = async { searchItem1() }
    val item2 = async { searchItem2() }
    PrintUtils.print("The items are ${item1} and ${item2}\n")
    PrintUtils.print("The items are ${item1.await()} and ${item2.await()}\n")
}