@file:JvmName("StringFunctions")
package chapter03functions

/**
 *   Author:Zheng Jun
 *   E-mail:zhengjun1987@outlook.com
 *   Date:2018/10/27 15:55
 *   Project:KotlinInAction
 */


public class JoinKt {
    public fun <T> joinToString(
            collection: Collection<T>,
            separator: String = ",",
            prefix: String = "",
            postfix: String = ""): String {
        val stringBuffer = StringBuffer(prefix)
        for (i in 0 until collection.size - 1) {
            stringBuffer.append(collection.elementAt(i).toString())
            stringBuffer.append(separator)
        }
        stringBuffer.append(collection.last().toString())
        stringBuffer.append(postfix)
        println(this.javaClass.canonicalName)
        return stringBuffer.toString()
    }
}

fun String.lastCharacter():Char = this[length-1]

fun main(args: Array<String>) {
    println("\"Frank\".lastCharacter() = ${"Frank".lastCharacter()}")
    println("窗含西岭千秋雪".lastCharacter())
}