package chapter02basis

fun fizzBuzz(i:Int) =
    when {
        i % 15 == 0 -> "FizzBuzz "
        i % 5 == 0 -> "Buzz "
        i % 3 == 0 -> "Fizz "
        else -> "$i "
    }


fun main(args: Array<String>) {
    for (i in 1..100) {
        print(fizzBuzz(i))
    }
}