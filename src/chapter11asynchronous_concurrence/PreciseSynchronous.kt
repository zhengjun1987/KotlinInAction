package chapter11asynchronous_concurrence

import kotlinx.coroutines.runBlocking
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

class PreciseShop(private val goods: HashMap<Long, Int>) {
    private val reentrantLock = ReentrantLock()
    fun buyGoods(id: Long) {
        reentrantLock.withLock {
            val i = goods[id]
            if (i != null && i > 0) {
                goods[id] = i - 1
                PrintUtils.print("Good id:$id -- sell 1 -- stock ${i - 1}\n")
            }
        }
    }
}

class ShopApi {
    private val A_goods = hashMapOf<Long, Int>()
    private val B_goods = hashMapOf<Long, Int>()
    private var shopA: PreciseShop
    private var shopB: PreciseShop

    init {
        A_goods.put(1, 10)
        A_goods.put(2, 15)
        B_goods.put(1, 20)
        B_goods.put(2, 10)
        shopA = PreciseShop(A_goods)
        shopB = PreciseShop(B_goods)
    }

    fun buyGoods(shopName: String, id: Long) {
        when (shopName) {
            "A" -> {
                shopA.buyGoods(id)
            }
            "B" -> {
                shopB.buyGoods(id)
            }
            else -> {
            }
        }
    }
}

fun main(args: Array<String>) = runBlocking {
    val shopApi = ShopApi()
    shopApi.buyGoods("A",1)
    shopApi.buyGoods("B",2)
}