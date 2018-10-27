package chapter03functions

import java.lang.IllegalArgumentException

/**
 *   Author:Zheng Jun
 *   E-mail:zhengjun1987@outlook.com
 *   Date:2018/10/27 23:11
 *   Project:KotlinInAction
 */

class User(val id:Int,val name:String,val address:String)

fun saveUser(user: User) {
//    if (user.name.isEmpty()) {
//        throw IllegalArgumentException(
//                "Cannot save user${user.id}: empty Name"
//        )
//    }
//    if (user.address.isEmpty()) {
//        throw IllegalArgumentException(
//                "Cannot save user${user.id}: empty Address"
//        )
//    }

    fun validate(user: User,value:String,fieldName:String){
        if (value.isEmpty()) {
            throw IllegalArgumentException("Cannot save user ${user.id}:empty $fieldName")
        }
    }
    validate(user,user.name,"Name")
    validate(user,user.address,"Address")

    println("user = $user")
}

fun User.saveAfterValidation(){

    fun validate(user: User,value:String,fieldName:String){
        if (value.isEmpty()) {
            throw IllegalArgumentException("Cannot save user ${user.id}:empty $fieldName")
        }
    }
    validate(this,this.name,"Name")
    validate(this,this.address,"Address")

    println("this = ${this}")
}


fun main(args: Array<String>) {
    val user1 = User(id = 1, name = "Frank Underwood", address = "1339 St.5 Queen District,New York City")
    user1.saveAfterValidation()
    saveUser(user1)

    val user = User(id = 1, name = "", address = "")
    user.saveAfterValidation()
    saveUser(user)
}