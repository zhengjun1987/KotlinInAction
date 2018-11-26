package chapter07operators

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 *   Author:Zheng Jun
 *   E-mail:zhengjun1987@outlook.com
 *   Date:22/11/2018 00:05
 *   Project:KotlinInAction
 */

class Email(val title: String, val content: String) {
    override fun toString(): String {
        return "Email(title='$title', content='$content')"
    }
}

open class PropertyChangeAware {
    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }
}

class ObservableProperty(val propName: String, var propValue: Int, val changeSupport: PropertyChangeSupport) {
    fun getValue(): Int = propValue
    fun setValue(newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(propName, oldValue, newValue)
    }
}

class ObservableProp(var propValue: Int, val changeSupport: PropertyChangeSupport) {
    operator fun getValue(member: Member, prop: KProperty<*>): Int = propValue
    operator fun setValue(member: Member, prop: KProperty<*>, newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }
}

class Member(val name: String, age: Int, salary: Int) : PropertyChangeAware() {
//    var age: Int = age
////        set(value) {
////            val oldValue = field
////            field = value
////            changeSupport.firePropertyChange("age", oldValue, value)
////        }
////
////    var salary: Int = salary
////        set(value) {
////            val oldValue = field
////            field = value
////            changeSupport.firePropertyChange("salary", oldValue, value)
////        }


//    val _age = ObservableProperty("age",age,changeSupport)
//    var age:Int
//        get() = _age.getValue()
//        set(value) {_age.setValue(value)}
//
//    val _salary = ObservableProperty("salary",salary,changeSupport)
//    var salary:Int
//        get() = _salary.getValue()
//        set(value) {_salary.setValue(value)}

//    var age:Int by ObservableProp(age,changeSupport)
//    var salary:Int by ObservableProp(salary,changeSupport)

    private val observer = { prop: KProperty<*>, oldValue: Int, newValue: Int ->
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }

    var age:Int by Delegates.observable(age,observer)
    var salary:Int by Delegates.observable(salary,observer)

}

fun loadMails(person: Person): List<Email> {
    println("<top>.loadMails")
    println("person = [$person]")
    return listOf(Email("titleA", "ContentA"), Email("titleB", "ContentB"), Email("titleC", "ContentC"))
}

class C {
    private val _attributes = hashMapOf<String,String>()
    fun setAttributes(attrName:String,value: String){
        _attributes[attrName] = value
    }
    var name by _attributes
}

fun main(args: Array<String>) {
    val member = Member("Dmitry", 34, 2000)
    member.addPropertyChangeListener(PropertyChangeListener { evt ->
        println("evt.propertyName = [${evt.propertyName}]  evt.oldValue = [${evt.oldValue}]  evt.newValue = [${evt.newValue}]  ")
    })
    member.age = 35
    member.salary = 2100

    println("member.age = ${member.age}")
    println("member.salary = ${member.salary}")

    val c = C()
//    println("c.name = ${c.name}")  NoSuchElementException: Key name is missing in the map.
    c.setAttributes("name","Frank Underwood")
    println("c.name = ${c.name}")
}


//        evt.propertyName = [age]  evt.oldValue = [34]  evt.newValue = [35]
//        evt.propertyName = [salary]  evt.oldValue = [2000]  evt.newValue = [2100]
//        member.age = 35
//        member.salary = 2100
//        c.name = Frank Underwood
//
//        Process finished with exit code 0

