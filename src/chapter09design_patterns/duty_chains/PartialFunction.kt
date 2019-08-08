package chapter09design_patterns.duty_chains

import java.lang.IllegalArgumentException

class PartialFunction<in P1, out R>(private val defineAt: (P1) -> Boolean, private val f: (P1) -> R) : (P1) -> R {
    override fun invoke(p1: P1): R {
        if (defineAt(p1)) {
            return f(p1)
        } else {
            throw IllegalArgumentException("Value ($p1) is invalid in definition!")
        }
    }

    fun isDefineAt(p1: P1) = defineAt(p1)
}

infix fun <P1, R> PartialFunction<P1, R>.orElse(other: PartialFunction<P1, R>): PartialFunction<P1, R> {
    return PartialFunction({ this.isDefineAt(it) || other.isDefineAt(it) }) { p1: P1 ->
        when {
            this.isDefineAt(p1) -> this(p1)
            else -> other(p1)
        }
    }
}

fun main(args: Array<String>) {
    val greaterThan5 = PartialFunction(defineAt = { it: Int -> it > 5 }, f = { i: Int -> i })
    val result = greaterThan5(6)
    println("result = ${result}")
//    greaterThan5(4)

    val groupLeader = {
        val defineAt = {it:Activity -> it.money <= 200}
        val handler = {it:Activity -> println("Group Leader handled : ${it.name}")}
        PartialFunction(defineAt,handler)
    }()

    val chairman = PartialFunction(
            defineAt = {it:Activity -> it.money <= 500 },
            f = {it:Activity -> println("Chairman handled : ${it.name}")}
    )

    val college = PartialFunction(
            defineAt = {it:Activity -> it.money <= 1000 },
            f = {it:Activity -> println("College handled : ${it.name}")}
    )

    val forbidden = PartialFunction(
            defineAt = {it:Activity -> it.money > 1000 },
            f = {it:Activity -> println("College denied : ${it.name}")}
    )

    val dutyChain = groupLeader orElse chairman orElse college orElse forbidden
    dutyChain(Activity("Buy a mark pen", 10))
    dutyChain(Activity("Team building", 250))
    dutyChain(Activity("Debate match", 650))
    dutyChain(Activity("Annual meeting of the college", 1200))
}