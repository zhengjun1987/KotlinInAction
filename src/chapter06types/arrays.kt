package chapter06types

import java.util.*

/**
 *   Author:Zheng Jun
 *   E-mail:zhengjun1987@outlook.com
 *   Date:9/11/2018 00:20
 *   Project:KotlinInAction
 */

fun main(args: Array<String>) {
    for (index in args.indices) {
        println("Argument $index is ${args[index]}")
    }

    val strings = Array(26){ i -> ('a' + i).toString() }
    println("strings.joinToString() = ${strings.joinToString()}")

    println("%s/%s/%s".format(*strings))

    val intArray = IntArray(5) { (it + 1) * (it + 1) }
    println("intArray = ${Arrays.toString(intArray)}")

    args.forEachIndexed {index: Int, s: String ->
        println("Argument $index is $s")
    }
}