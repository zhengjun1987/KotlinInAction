package chapter03functions

import java.util.*

/**
 * Created by zhengjun
 * Date: 2019/7/28
 * Mail:zhengjun1987@outlook.com
 */
class Demo(val age: Int = 1) {
    constructor(birth: Date) : this(age = getYearByBirth(birth))

    override fun toString(): String {
        return "Demo(age=$age)"
    }

}

private fun getYearByBirth(birth: Date): Int {
    val date = Date()
    val life = date.time - birth.time
    return (life / (365L * 24 * 3600 * 1000)).toInt()
}

fun main(args: Array<String>) {
    println("Demo(Date()) = ${Demo(Date(87,7,2))}")
}