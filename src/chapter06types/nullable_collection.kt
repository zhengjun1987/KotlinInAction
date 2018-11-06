package chapter06types

import java.io.BufferedReader
import java.io.StringReader

/**
 *   Author:Zheng Jun
 *   E-mail:zhengjun1987@outlook.com
 *   Date:7/11/2018 00:07
 *   Project:KotlinInAction
 */

fun readNumbers(reader: BufferedReader):List<Int?>{
    val arrayList = ArrayList<Int?>()
    for (line in reader.lineSequence()) {
        try {
            val number = line.toInt()
            arrayList.add(number)
        } catch (e: NumberFormatException) {
            arrayList.add(null)
        }
    }
    return arrayList
}

fun addValidNumbers(numbers:List<Int?>){
    var sumOfValidNumbers = 0
    var invalidNumbers = 0
    for (number in numbers) {
        if (number != null) {
            sumOfValidNumbers += number
        } else {
            invalidNumbers++
        }
    }
    println("sumOfValidNumbers = $sumOfValidNumbers")
    println("invalidNumbers = $invalidNumbers")
}

fun main(args: Array<String>) {
    val arrayList = ArrayList<String?>(10)
    println("arrayList.size = ${arrayList.size}")
    arrayList.add(null)
    arrayList.add(null)
    arrayList.add(null)
    println("arrayList.size = ${arrayList.size}")
    arrayList.add("第三极")
    println("arrayList.size = ${arrayList.size}")

    val bufferedReader = BufferedReader(StringReader("1\nabc\n42"))
    val readNumbers = readNumbers(bufferedReader)
    addValidNumbers(readNumbers)

    println("readNumbers.filterNotNull() = ${readNumbers.filterNotNull()}")
}