package chapter11asynchronous_concurrence

import kotlinx.coroutines.*

fun main(args: Array<String>) {
    /* Kotlin的协程扩展库仅限于Android使用 */
//    println("Hello-${Thread.currentThread().name}")
//    val runCatching = runCatching {
//        println("Hello-${Thread.currentThread().name}")
//        repeat(5) {
//            Thread.sleep(1000)
//            println("Hello-${Thread.currentThread().name}")
//            if (System.currentTimeMillis() / 1000 % 10 == 3L) {
//                throw IllegalStateException("END!")
//            }
//        }
//        0
//    }
//    println("runCatching = ${runCatching}")
    PrintUtils.print("==========================================")
    val timeMillis: Long = 50
    val job = GlobalScope.launch {
        delay(timeMillis)
        println("World!")
        PrintUtils.print("==========================================")
    }
    println("\njob = ${job}")
    PrintUtils.print("Hello,")
    Thread.sleep(timeMillis * 2)
}