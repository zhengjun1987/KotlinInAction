package chapter07operators

import kotlin.reflect.KProperty

/**
 *   Author:Zheng Jun
 *   E-mail:zhengjun1987@outlook.com
 *   Date:20/11/2018 23:50
 *   Project:KotlinInAction
 */
data class NameComponents(val name:String,val ext:String)

fun splitFileName(fullName:String):NameComponents {
    val list = fullName.split(".")
    return NameComponents(list[0],list[1])
}

fun printEntries(map: Map<String,String>){
    for ((key,value) in map){
        println("$key => $value")
    }
}

fun main(args: Array<String>) {
    val point = Point(10, 20)
    val (x,y) = point
    println("x = $x")
    println("y = $y")

    val (name,ext) = splitFileName("/Users/zhengjun/IdeaProjects/KotlinInAction/lib/hamcrest-core-1.3.jar")
    println("name = $name")
    println("ext = $ext")

    val mapOf = mapOf("Oracle" to "Java", "Jetbrains" to "Kotlin")
    printEntries(mapOf)
}