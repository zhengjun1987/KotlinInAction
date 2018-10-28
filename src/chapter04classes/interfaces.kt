package chapter04classes

/**
 *   Author:Zheng Jun
 *   E-mail:zhengjun1987@outlook.com
 *   Date:2018/10/27 23:43
 *   Project:KotlinInAction
 */

interface Clickable {
    fun onClick()
    fun showOff() = println("I'm a clickable!")
}

interface Focusable {
    fun setFocus(boolean: Boolean){
        println("I ${if (boolean) "got" else "lost"} focus!")
    }

    fun showOff() = println("I'm a Focusable!")
}