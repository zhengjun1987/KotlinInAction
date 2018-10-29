package chapter04classes.init

/**
 *   Author:Zheng Jun
 *   E-mail:zhengjun1987@outlook.com
 *   Date:2018/10/28 19:01
 *   Project:KotlinInAction
 */

class Context

class AttributeSet

open class View {
    constructor(ctx:Context){
        val mContext:Context = ctx
    }
    constructor(ctx:Context,attrs:AttributeSet){
        val mContext:Context = ctx
        val mAttrs:AttributeSet = attrs
    }
}

class Button:View{
    constructor(ctx: Context):super(ctx){}
    constructor(ctx: Context,attrs: AttributeSet):super(ctx,attrs){}
}

fun main(args: Array<String>) {
    val button = Button(Context(), AttributeSet())
}


class PrivateUser(override val nickname: String) :User

class SubscribingUser(val email:String):User {
    override val nickname: String
        get() = email.substringBeforeLast("@")
}

class FacebookUser(val accountId:Int):User {
    override val nickname: String
        get() = getNicknameFromId(accountId)
}

fun getNicknameFromId(accountId: Int): String {
    return "FacebookUser$accountId"
}