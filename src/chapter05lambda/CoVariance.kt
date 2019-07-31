package chapter05lambda

import java.lang.IndexOutOfBoundsException

fun <T> copy(src:Array<T>,dest:Array<T>){
    if (src.size != dest.size){
        throw IndexOutOfBoundsException()
    } else {
        src.forEachIndexed{
            index,t ->
            dest[index] = t
        }
    }
}

fun <T> copyOut(src:Array<out T>,dest:Array<T>){
    if (src.size != dest.size){
        throw IndexOutOfBoundsException()
    } else {
        src.forEachIndexed{
            index,t ->
            dest[index] = t
        }
    }
}

fun <T> copyIn(src:Array<T>,dest:Array<in T>){
    if (src.size != dest.size){
        throw IndexOutOfBoundsException()
    } else {
        src.forEachIndexed{
            index,t ->
            dest[index] = t
        }
    }
}