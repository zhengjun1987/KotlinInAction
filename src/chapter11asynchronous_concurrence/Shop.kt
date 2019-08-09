package chapter11asynchronous_concurrence

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

class Shop {
    val goods = hashMapOf<Long, Int>()

    init {
        goods[1] = 100
        goods[0] = 15
    }

    @Synchronized
    fun buyGoods(id: Long) {
        val stock = goods[id]
        if (stock != null && stock > 0) {
            goods[id] = (stock - 1)
            PrintUtils.print("Good id:$id -- sell 1 -- stock ${stock - 1}\n")
        }
    }

    fun buyGoods2(id: Long) {
        synchronized(this) {
            val stock = goods[id]
            if (stock != null) {
                goods[id] = (stock - 1)
            }
        }
    }

    val reentrantLock = ReentrantLock()

    fun buyGoods3(id: Long) {
        reentrantLock.lock()
        try {
            val stock = goods[id]
            if (stock != null && stock > 0) {
                goods[id] = (stock - 1)
                PrintUtils.print("Good id:$id -- sell 1 -- stock ${stock - 1}\n")
            }
        } catch (e: Exception) {
            PrintUtils.print(e.toString() + "\n")
        } finally {
            reentrantLock.unlock()
        }
    }

    fun buyGoods4(id: Long) {
        reentrantLock.withLock {
            val stock = goods[id]
            if (stock != null && stock > 0) {
                goods[id] = (stock - 1)
                PrintUtils.print("Good id:$id -- sell 1 -- stock ${stock - 1}\n")
            }
        }
    }
}

fun main(args: Array<String>) {
    val shop = Shop()
    repeat(shop.goods[1]!!) {
        GlobalScope.launch {
            shop.buyGoods4(it.toLong() % 2)
        }
    }
    Thread.sleep(3000L)
}