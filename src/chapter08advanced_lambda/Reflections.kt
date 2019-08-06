package chapter08advanced_lambda

import chapter06types.Stuff
import kotlin.reflect.KMutableProperty
import kotlin.reflect.KProperty
import kotlin.reflect.full.*

data class User(val name: String, val age: Int)

object Mapper {
    fun <T : Any> toMap(a: T): Map<String, Any> {
        println("a::class = ${a::class}")
        println("a::class.java = ${a::class.java}")
        println("a::class.java.kotlin = ${a::class.java.kotlin}")
        return a::class.memberProperties.map { m ->
            val kProperty = m as KProperty<T>
            println("kProperty = ${kProperty.javaClass}")
            kProperty.name to kProperty.call(a)
        }.toMap()
    }
}

sealed class Nat {
    companion object {
        object Zero : Nat()
    }

    val Companion._0
        get() = Zero

    fun <A : Nat> Succ<A>.preceed(): A = prev
}

data class Succ<N : Nat>(val prev: N) : Nat()

fun <A : Nat> Nat.plus(other: A): Nat =
        when {
            other is Succ<*> -> Succ(this.plus(other.prev))
            else -> this
        }

fun main(args: Array<String>) {
    val user = User("Humora", 17)
    val map = Mapper.toMap(user)
    println("Mapper.toMap(user) = $map")

//    val list : MutableList<*> = mutableListOf(1, "juc", null)
    val list = mutableListOf(1, "juc", null)
    list.add(3)
    println("list = $list")

    println("Nat.Companion::class.isCompanion = ${Nat.Companion::class.isCompanion}")
    println("Nat::class.isSealed = ${Nat::class.isSealed}")
    println("Nat.Companion::class.objectInstance = ${Nat.Companion::class.objectInstance}")
    println("Nat::class.companionObjectInstance = ${Nat::class.companionObjectInstance}")
    println("Nat::class.declaredMemberExtensionProperties.map { it.name } = ${Nat::class.declaredMemberExtensionProperties.map { it.name }}")
    println("Succ::class.declaredMemberExtensionProperties.map { it.name } = ${Succ::class.declaredMemberExtensionProperties.map { it.name }}")
    println("Succ::class.memberExtensionProperties.map { it.name } = ${Succ::class.memberExtensionProperties.map { it.name }}")
    println("Succ::class.starProjectedType = ${Succ::class.starProjectedType}")
    println("Nat::class.declaredMemberExtensionFunctions.map { it.name } = ${Nat::class.declaredMemberExtensionFunctions.map { it.name }}")
    println("Succ::class.declaredMemberExtensionFunctions.map { it.name } = ${Succ::class.declaredMemberExtensionFunctions.map { it.name }}")
    println("Succ::class.memberExtensionFunctions.map { it.name } = ${Succ::class.memberExtensionFunctions.map { it.name }}")

    println("Succ::class.members.map { it.name } = ${Succ::class.members.map { it.name }}")
    println("Succ::class.memberFunctions.map { it.name } = ${Succ::class.memberFunctions.map { it.name }}")

    Succ::class.apply {
        println("this.memberProperties.map { it.name } = ${this.memberProperties.map { it.name }}")
        println("this.memberExtensionProperties.map { it.name } = ${this.memberExtensionProperties.map { it.name }}")
        println("this.memberExtensionFunctions.map { it.name } = ${this.memberExtensionFunctions.map { it.name }}")
    }

    Nat::class.apply {
        println("this.members.map { it.name } = ${this.members.map { it.name }}")
        println("this.declaredMemberExtensionFunctions.map { it.name } = ${this.declaredMemberExtensionFunctions.map { it.name }}")
        this.declaredMemberExtensionFunctions.forEach {
            val args1 = Succ(Nat.Companion.Zero)
            val call = it.call(args1, args1)
            println("call = ${call}")
        }
    }

    Nat::class.members.forEach {
        println("============${it.name}=============")
        println("it.isAbstract = ${it.isAbstract}")
        println("it.isFinal = ${it.isFinal}")
        println("it.isOpen = ${it.isOpen}")
        println("it.parameters.map { it.name } = ${it.parameters.map { it.name }}")
        println("it.returnType.toString() = ${it.returnType.toString()}")
        println("it.typeParameters.map { it.name } = ${it.typeParameters.map { it.name }}")
        println("it.visibility.toString() = ${it.visibility.toString()}")
    }

    val stuff = Stuff("郑军", "hangzhou")
    println("stuff = ${stuff}")
    val properties = stuff::class.memberProperties
    for (property in properties) {
        when (property) {
            is KMutableProperty<*> -> {
                property.setter.call(stuff,"guangzhou")
            }
            else -> {
                val call = property.call(stuff)
                println("call = ${call}")
            }
        }
    }
    println("stuff = ${stuff}")
    println()
    for (member in stuff::class.members) {
        println("${member.name} -> ${member.parameters.map { it.type }} -- ${member.returnType}")
    }

    val ints = listOf(1, 2, 3)
    println("ints::class.typeParameters = ${ints::class.typeParameters}")
    ints::class.members.forEach {
        println("${it.name} --> ${it.returnType.classifier} --> ${it.typeParameters}")
    }
}