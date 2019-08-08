package chapter09design_patterns.observer

import kotlin.properties.Delegates

var value:Int by Delegates.vetoable(0){
    _,old,new ->
    new > 0
}

fun main(args: Array<String>) {
    println("value = ${value}")
    value = 1
    println("value = ${value}")
    value = -1
    println("value = ${value}")
}