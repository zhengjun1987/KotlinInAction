package chapter04classes.`object`

import chapter02basis.Person
import chapter04classes.init.getNicknameFromId
import java.awt.Frame
import java.awt.Window
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.io.File

object Payroll {
    val allEmployees = arrayListOf<Person>()

    fun addEmployee(person: Person) {
        allEmployees.add(person)
    }

    fun calculateSalary() {
        for (person in allEmployees) {
            println("person = $person")
        }
    }
}

object CaseInsensitiveComparator : Comparator<File> {
    override fun compare(o1: File, o2: File): Int {
        return o1.path.compareTo(o2.path, ignoreCase = true)
    }
}

class A private constructor(){
    companion object Loader {
        private const val name: String = "Buffer"
        val instance:A = A()
        fun bar() {
            println("A.bar() called! $name")
        }
    }
}

class User private constructor(private val nickname:String){
    companion object Loader {
        fun newSubscribingUser(email:String):User{
            return User(email.substringBefore("@"))
        }
        fun newFacebookUser(accountId:Int):User{
            return User(getNicknameFromId(accountId))
        }
        fun fromJSON(json:String):User = User(json.substring(2,json.length-1))
    }

    override fun toString(): String {
        return "User(nickname='$nickname')"
    }
}

fun User.Loader.fromNickname(nickname: String):User = newSubscribingUser(nickname)

fun countClicks(window: Window){
    var count = 0
    window.addMouseListener(object :MouseAdapter(){
        override fun mouseClicked(e: MouseEvent?) {
            super.mouseClicked(e)
            count++
        }
    })
}

fun main(args: Array<String>) {
    Payroll.addEmployee(Person.fromName("Frank Underwood"))
    Payroll.addEmployee(Person.fromName("Jason Stevenson"))
    Payroll.allEmployees.add(Person.fromName("Scarlet Johnson"))
    Payroll.calculateSalary()

    println("Payroll.allEmployees.sortedWith(Person.NameComparator) = ${Payroll.allEmployees.sortedWith(Person.NameComparator)}")

    val fileList = listOf(File("/Z"),
            File("/a"))
    println("fileList.sortedWith(CaseInsensitiveComparator) = ${fileList.sortedWith(CaseInsensitiveComparator)}")

    A.bar()
//    println("A() = ${A()}")
    println("A.instance = ${A.instance}")

    println("User.newFacebookUser(396479696) = ${User.newFacebookUser(396479696)}")
    println("User.newSubscribingUser(\"zhengjun1987@outlook.com\") = ${User.newSubscribingUser("zhengjun1987@outlook.com")}")
    println("User.Loader.newFacebookUser(664898646) = ${User.newFacebookUser(664898646)}")

    println("User.fromNickname(\"风清扬\") = ${User.fromNickname("风清扬")}")

    val window = Window(Frame()).apply {
        addMouseListener(
                object : MouseAdapter(){
                    override fun mouseEntered(e: MouseEvent?) {
                        super.mouseEntered(e)
                    }

                    override fun mouseClicked(p0: MouseEvent?) {
                        super.mouseClicked(p0)
                        println("p0 = [${p0}]")
                    }
                }
        )
    }

    val listener = object : MouseAdapter() {
        override fun mouseReleased(e: MouseEvent?) {
            super.mouseReleased(e)
        }
    }
}