package chapter03functions.data

import java.util.*
import kotlin.Comparator

/**
 * Created by zhengjun
 * Date: 2019/7/29
 * Mail:zhengjun1987@outlook.com
 */

class Prize private constructor(val name: String, val count: Int, val type: Int) {
    companion object {
        val TYPE_REDPACK = 0
        val TYPE_COUPON = 1
        val TYPE_COMMON = 2

        private val defaultCommonPrize: Prize = Prize("红包", 10, TYPE_COMMON)

        fun newRedPackPrize(name: String, count: Int) = Prize(name, count, TYPE_REDPACK)
        fun newCouponPrize(name: String, count: Int) = Prize(name, count, TYPE_COUPON)
        fun defaultCommonPrize() = defaultCommonPrize
    }
}

fun Prize.isRedPack() = this.type == Prize.TYPE_REDPACK

object DatabaseConfig {
    var host: String = "127.0.0.1"
    var port = 3306
    var username = "root"
    var password = ""
}

fun main(args: Array<String>) {
    val prize = Prize.defaultCommonPrize()
    println("prize.isRedPack() = ${prize.isRedPack()}")

    val redPackPrize = Prize.newRedPackPrize("恭喜发财", 100)
    println("redPackPrize.isRedPack() = ${redPackPrize.isRedPack()}")

    DatabaseConfig.host = "localhost"

    val list = arrayListOf("redpack", "score", "card")
    Collections.sort(list, object : Comparator<String> {
        override fun compare(o1: String?, o2: String?): Int {
            if (o1 == null) return -1
            else if (o2 == null) return 1
            return o1.compareTo(o2)
        }
    })
    println("list = ${list}")

    Collections.sort(list,Comparator<String>{
        s1,s2 ->
        if (s1 == null) return@Comparator 1
        else if (s2 == null) return@Comparator -1
        return@Comparator -s1.compareTo(s2)
    })
    println("list = ${list}")
}

