package chapter06types

/**
 *   Author:Zheng Jun
 *   E-mail:zhengjun1987@outlook.com
 *   Date:5/11/2018 20:50
 *   Project:KotlinInAction
 */

class Stuff(val firstName: String, var lastName: String) {
    override fun equals(other: Any?): Boolean {
        val otherPerson = other as? Stuff ?: return false
        return firstName == otherPerson.firstName && lastName == otherPerson.lastName
    }

    override fun hashCode(): Int {
        return firstName.hashCode() + 37 * lastName.hashCode()
    }

    override fun toString(): String {
        return "Stuff(firstName='$firstName', lastName='$lastName')"
    }


}