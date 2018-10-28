package chapter04classes.fields

import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import java.util.*
import kotlin.collections.ArrayList

/**
 *   Author:Zheng Jun
 *   E-mail:zhengjun1987@outlook.com
 *   Date:2018/10/28 19:37
 *   Project:KotlinInAction
 */

class User(val name: String) {

    var address: String = "unspecified"
        set(value) {
            println("field = $field")
            println("value = $value")
            println("address = $address")
            println("name = $name")
            println("""
                Address was changed for $name:
                "$field" -> "$value".
            """.trimIndent())
            field = value
        }

    override fun toString(): String {
        return "User(name='$name', address='$address')"
    }
}

class LengthCounter {
    var counter: Int = 0
        private set

    fun addWords(words: String) {
        counter += words.length
    }

    override fun toString(): String {
        return "LengthCounter(counter=$counter)"
    }
}

class Client(val name: String, val postalCode: Int) {
    override fun toString(): String {
        return "Client(name='$name', postalCode=$postalCode)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Client

        if (name != other.name) return false
        if (postalCode != other.postalCode) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + postalCode
        return result
    }

    /**
     * 最好将所有成员变量设置成val final的
     * 数据类和不可变性
     * @param name
     * @param postalCode
     */
    fun copy(name: String = this.name, postalCode: Int = this.postalCode): Client = Client(name, postalCode)
}

class DelegatingCollection1<T> : Collection<T> {
    private val innerList = arrayListOf<T>()

    override val size: Int
        get() = innerList.size //To change initializer of created properties use File | Settings | File Templates.

    override fun contains(element: T): Boolean = innerList.contains(element)

    override fun containsAll(elements: Collection<T>): Boolean = innerList.containsAll(elements)

    override fun isEmpty(): Boolean = innerList.isEmpty()

    override fun iterator(): Iterator<T> = innerList.iterator()

    override fun toString(): String {
        return innerList.toString()
    }
}

class DelegatingCollection2<T>(val innerList: Collection<T> = ArrayList()) : Collection<T> by innerList {

    override fun toString(): String {
        return "DelegatingCollection2(innerList=$innerList)"
    }
}


fun main(args: Array<String>) {
    val user = User("Frank")
    println("user = ${user.toString()}")
    println("user.address = ${user.address}")
    user.address = "ElsenHeimerstrasse 47, 80686 Muenchen"
    println("user.address = ${user.address}")

    val lengthCounter = LengthCounter()
    lengthCounter.addWords("ElsenHeimerstrasse")
    lengthCounter.addWords("Muenchen")
    println("lengthCounter = $lengthCounter")

    val client = Client("Alice", 342562)
    println("client = $client")
    val client1 = Client("Alice", 342562)
    val client2 = client
    println("client.equals(client1) = ${client.equals(client1)}")//IDE会提供"=="的提示
    println("client == client1 : ${client == client1}")//"=="被Kotlin重定向到equals方法
    println("client === client1 : ${client === client1}")
    println("client === client2 : ${client === client2}")

    println("client == client.copy() : ${client == client.copy()}")
    println("client === client.copy() : ${client === client.copy()}")

    val delegatingCollection1 = DelegatingCollection1<String>()
    println("delegatingCollection1 = ${delegatingCollection1.toString()}")

    val delegatingCollection2 = DelegatingCollection2(listOf("aaa", "nnn"))
    println("delegatingCollection2 = $delegatingCollection2")
}

class CountingSet<T>(val innerSet: MutableCollection<T> = HashSet()) : MutableCollection<T> by innerSet {
    var objectsAdd:Int = 0

    override fun add(element: T): Boolean {
        objectsAdd++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectsAdd += elements.size
        return innerSet.addAll(elements)
    }
}