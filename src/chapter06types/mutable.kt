package chapter06types

import java.io.File

/**
 *   Author:Zheng Jun
 *   E-mail:zhengjun1987@outlook.com
 *   Date:7/11/2018 23:57
 *   Project:KotlinInAction
 */

fun <T> copyElements(source:Collection<T>,target:MutableCollection<T>){
    target += source
}

class FileIndexer:FileContentProcessor{
    override fun processContents(file: File, binaryContents: ByteArray?, textContents: MutableList<String>?) {
    }
}

class PersonParser:DataParser<Person>{
    override fun parseData(input: String, output: MutableList<Person>, errors: MutableList<String?>) {

    }
}

fun main(args: Array<String>) {
    val source = arrayListOf(3, 5, 7)
    val mutableCollection:MutableCollection<Int> = arrayListOf(1)
    copyElements(source,mutableCollection)
    println("mutableCollection = $mutableCollection")

    val list = listOf("a", "b", "c")
    println("CollectionUtils.uppercaseAll(list) = ${CollectionUtils.uppercaseAll(list)}")
    println("list = $list")
}