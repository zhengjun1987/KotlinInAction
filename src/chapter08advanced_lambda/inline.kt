package chapter08advanced_lambda

import java.util.concurrent.locks.Lock

/**
 *   Author:Zheng Jun
 *   E-mail:zhengjun1987@outlook.com
 *   Date:27/12/2018 23:36
 *   Project:KotlinInAction
 */

fun main(args: Array<String>) {
}

fun foo(lock: Lock){
    println("Before Sync...")
    sychronized(lock){
        println("Action!")
    }
    println("After Sync...")
}

inline fun <T> sychronized(lock:Lock,action:()->T){
    lock.lock()
    val t = try {
        action.invoke()
    } finally {
        lock.unlock()
    }
    println("t = ${t.toString()}")
}