package outside

import java.util.*

fun main(args: Array<String>) {
    val toByteArray = "���bU.����������������������������������������������������������������������������������������������������������������������".toByteArray()
    println("toByteArray = ${Arrays.toString(toByteArray)}")
    println("toByteArray.size = ${toByteArray.size}")
}