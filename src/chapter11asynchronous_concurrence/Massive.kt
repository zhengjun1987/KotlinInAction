package chapter11asynchronous_concurrence

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicLong
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    val timeMillis = measureTimeMillis {
        val atomicLong = AtomicLong(0)
        for (i in 1..1000_00) {

            thread(start = true) {
                atomicLong.addAndGet(i.toLong())
            }
//            atomicLong = 500000500000
//            timeMillis = 53166


//            GlobalScope.launch {
//                atomicLong.addAndGet(i.toLong())
//            }
//            atomicLong = 4775136675
//            timeMillis = 673
        }
        println("atomicLong = ${atomicLong.get()}")
    }
    println("timeMillis = $timeMillis")
}