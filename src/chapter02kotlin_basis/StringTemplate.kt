package chapter02kotlin_basis

/**
 *   Author:Zheng Jun
 *   E-mail:zhengjun1987@outlook.com
 *   Date:2018/5/28 23:40
 *   Project:KotlinInAction
 */

fun main(args: Array<String>) {
    val name = if (args.isNotEmpty()) args[0] else "Kotlin"
    println("Hello,$name!")
//    Hello,Kotlin!

    println("Hello,${if (args.isEmpty()) "Kotlin" else args[0]}!")
//    Hello,Kotlin!
}