package outside

/**
 *   Author:Zheng Jun
 *   E-mail:zhengjun1987@outlook.com
 *   Date:2018/10/27 16:40
 *   Project:KotlinInAction
 */

import chapter03functions.lastCharacter as lastchar

fun main(args: Array<String>) {
//    println("de jav".lastCharacter())
    println("de jav".lastchar())
    println("de jav".last())

    val arrayList = ArrayList<String>(10)
    arrayList.add("de jav")
    arrayList.add("de jav1")
    val list = ArrayList<String>()
    list.addAll(arrayList)
    println("list.size = ${list.size}")

    var leftHandRegistered = false
    var rightHandRegistered = false
    val state = (1 shl 4) + 1
    rightHandRegistered = state and 31 != 0
    leftHandRegistered = state and (31 shl 5) != 0
    println("Integer.toBinaryString(state) = ${Integer.toBinaryString(state)}")
    println("leftHandRegistered = $leftHandRegistered")
    println("rightHandRegistered = $rightHandRegistered")
}