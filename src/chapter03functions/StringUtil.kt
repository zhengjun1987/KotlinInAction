@file:JvmName("StringUtil")
package chapter03functions

import java.io.File

/**
 *   Author:Zheng Jun
 *   E-mail:zhengjun1987@outlook.com
 *   Date:2018/10/27 15:59
 *   Project:KotlinInAction
 */

fun <T> joinToString(
        collection: Collection<T>,
        separator: String = ",",
        prefix: String = "",
        postfix: String = ""): String {
    println("collection = [$collection], separator = [$separator], prefix = [$prefix], postfix = [$postfix]")
    val stringBuffer = StringBuffer(prefix)
    for (i in 0 until collection.size - 1) {
        stringBuffer.append(collection.elementAt(i).toString())
        stringBuffer.append(separator)
    }
    stringBuffer.append(collection.last().toString())
    stringBuffer.append(postfix)
    return stringBuffer.toString()
}

val String.lastChar:Char
    get() = last()

var StringBuffer.lastChar: Char
    get() = this.last()
    set(value:Char) {
        setCharAt(length-1,value)
    }

fun main(args: Array<String>) {
    val name = "Frank Underwood"
    print(joinToString(listOf(name,"Fiona Xue")))
    print(LINE_SEPARATOR)
    print(joinToString(listOf(name,"Fiona Xue")))
    print(LINE_SEPARATOR)

    println("name.lastChar = ${name.lastChar}")

    val stringBuffer = StringBuffer("Kotlin?")
    println("stringBuffer = $stringBuffer")
    stringBuffer.lastChar = '!'
    println("stringBuffer = $stringBuffer")

    var s = ""
    val split = "172.16.12.58".split(".")
    println("split = $split")
    s = "12.345-6.A"
    val regex = "\\.|-".toRegex()
    println("regex.javaClass.canonicalName = ${regex.javaClass.canonicalName}")//kotlin.text.Regex
    println(s.split(regex))
    println(s.split(".","-"))

    parsePath("/Users/zhengjun/IdeaProjects/KotlinInAction/src/chapter03functions/StringUtil.kt")
    parsePathRegex("/Users/zhengjun/IdeaProjects/KotlinInAction/src/chapter03functions/StringUtil.kt")

    val kotlinLogo = """| //
.|//
.|/ \"""
    println(kotlinLogo)
    println(kotlinLogo.trimMargin("."))
}

fun parsePath(path:String){
    println("File.separator = ${File.separator}")
    val dirPath = path.substringBeforeLast(File.separator)
    val fullName = path.substringAfterLast(File.separator)
    val postFix = fullName.substringAfterLast(".")
    val fileName = fullName.substringBeforeLast(".")
    println("dirPath = $dirPath")
    println("fullName = $fullName")
    println("fileName = $fileName")
    println("postFix = $postFix")
}

fun parsePathRegex(path: String){
    val toRegex = "(.+)/(.+)\\.(.+)".toRegex()
    val result = toRegex.matchEntire(path)
    val destructured = result?.destructured
    println("DIR:${destructured?.component1()} FILENAME:${destructured?.component2()} EXTENSION:${destructured?.component3()} ")
}