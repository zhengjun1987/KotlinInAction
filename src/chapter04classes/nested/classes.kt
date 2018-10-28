package chapter04classes.nested

/**
 *   Author:Zheng Jun
 *   E-mail:zhengjun1987@outlook.com
 *   Date:2018/10/28 17:15
 *   Project:KotlinInAction
 */

class Button : View {
    override fun getCurrentState(): State {
        val buttonState = ButtonState()
        buttonState.doAnything()
        return buttonState
    }

    override fun restoreState(state: State) {
        super.restoreState(state)
    }

    class ButtonState : State {
        fun doAnything() {
            println("javaClass.canonicalName = ${javaClass.canonicalName}")
        }
    }

}

fun main(args: Array<String>) {
    val buttonState = Button.ButtonState()
    buttonState.doAnything()

    val outer = Outer()
    val inner = outer.Inner()
    println("outer = $outer")
    println("inner.getOuterInstance() = ${inner.getOuterInstance()}")

    val sum = Expr.Sum(Expr.Sum(Expr.Num(1), Expr.Num(2)), Expr.Num(4))
    println("sum.eval() = ${sum.eval()}")

    User("Alice")
    User("Alice", true)
    User(isSubscribed = false, nickname = "Frank")
    User(nickname = "Eva")
}

class Outer {
    inner class Inner {
        fun getOuterInstance(): Outer = this@Outer
    }
}

sealed class Expr {
    class Num(val value: Int) : Expr()
    class Sum(val left: Expr, val right: Expr) : Expr()

    fun eval(): Int = when (this) {
        is Num -> value
        is Sum -> left.eval() + right.eval()
    }
}

//    class User constructor(_nickname:String){
//        val nickname:String
//        init {
//            nickname = _nickname
//        }
//    }

open class User(val nickname: String,
                val isSubscribed: Boolean = false)

class SubscribedUser(nickname: String) : User(nickname, true)

class SingleInstance private constructor() {
    private val singleInstance: SingleInstance
        get() = singleInstance
}

//class New:SingleInstance()