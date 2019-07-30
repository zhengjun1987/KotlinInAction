package chapter04classes

import chapter04classes.sealedclass.Day

/**
 *   Author:Zheng Jun
 *   E-mail:zhengjun1987@outlook.com
 *   Date:2018/10/27 23:43
 *   Project:KotlinInAction
 */
fun main(args: Array<String>) {
    val button = Button()
    button.onClick()
    button.showOff()
    button.setFocus(true)

    val talkativeButton = TalkativeButton()
//    talkativeButton.yell()
    talkativeButton.giveSpeech()
}

class Button :Clickable,Focusable {
    override fun onClick() {
        println("Button.onClick")
    }

    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
        println("Button.showOff")
    }
}

internal open class TalkativeButton:Focusable {
    private fun yell() = println("Hey!")
    protected fun whisper(){
        yell()
        println("Let's talk!")
    }
    fun speaking(){
        whisper()
    }
}

internal fun TalkativeButton.giveSpeech() {
//    this.whisper()
//    this.yell()
    //以上两个方法均无法调用的原因：元编程的本质是静态方法，无法获取到子类与父类之间的protected访问权限，
    //只能调用public、internal的方法
    speaking()
}

fun schedule(day: Day) =
    when(day) {
        is Day.SUN -> "play"
        else -> "work"
}