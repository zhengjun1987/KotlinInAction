package chapter02basis

import java.lang.Exception

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(expr: Expr): Int {
    return if (expr is Num) expr.value else if (expr is Sum) (eval(expr.left) + eval(expr.right)) else throw Exception("Unknown Expression")
}

fun eval2(expr: Expr): Int {
    if (expr is Num)
        return expr.value
    else if (expr is Sum)
        return eval2(expr.left) + eval2(expr.right)
    else
        throw Exception("Unknown Expression")
}

fun eval3(expr: Expr): Int =
        when (expr) {
            is Num -> expr.value
            is Sum -> eval3(expr.left) + eval3(expr.right)
            else -> throw Exception("")
        }

fun eval4(expr: Expr): Int =
        when (expr) {
            is Num -> {
                println("num = ${expr.value}")
                expr.value
            }
            is Sum -> {
                val leftV = eval4(expr.left)
                val rightV = eval4(expr.right)
                println("sum = $leftV + $rightV")
                leftV + rightV
            }
            else -> throw Exception("Unknown Expression")
        }

fun main(args: Array<String>) {
    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
    println(eval2(Sum(Sum(Num(1), Num(2)), Num(4))))
    println(eval3(Sum(Sum(Num(1), Num(2)), Num(4))))
    println(eval4(Sum(Sum(Num(1), Num(2)), Num(4))))
    println(eval4(Sum( Num(4),Sum(Num(1), Num(2)))))
}