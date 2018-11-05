package chapter06types

/**
 *   Author:Zheng Jun
 *   E-mail:zhengjun1987@outlook.com
 *   Date:5/11/2018 23:25
 *   Project:KotlinInAction
 */

fun verifyUserInput(input:String?){
    if (input.isNullOrBlank())
        println("Please fill the required blanks")
}

fun verifyUserInput2(input:String?){
    if (input.isNullOrEmpty())
        println("Please fill the required blanks")
}

fun <T> printHashcode(t:T){
    println(t?.hashCode())
}

fun <T:Any> printHashcode2(t:T){
    println(t.hashCode())
}

fun yellAt(people: People){
    println(people.name.toUpperCase()+"!!!")
}

fun main(args: Array<String>) {
    verifyUserInput("  ")
    verifyUserInput(null)
    verifyUserInput("")
    println("======================================")
    verifyUserInput2("  ")
    println("======================================")
    verifyUserInput2(null)
    verifyUserInput2("")
    println("======================================")

    println("printHashcode(null) = ${printHashcode(null)}")
    val name = "Zheng Jun"
    println("printHashcode(name) = ${printHashcode(name)}")

    printHashcode2(name)
//    printHashcode2(null)

//    yellAt(null) //Error:(50, 12) Kotlin: Null can not be a value of a non-null type People
    yellAt(People(null))

}