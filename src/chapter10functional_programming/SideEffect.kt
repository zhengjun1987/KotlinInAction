package chapter10functional_programming

sealed class Format
data class Print(val text:String):Format()
object NewLine:Format()

val string = listOf(Print("Hello"),NewLine,Print("Kotlin"))
fun unsafeInterpreter(str: List<Format>){
    str.forEach {
        when (it) {
            is Print -> {
                println(it.text)
            }
            else -> {
                return@forEach
                println("--")
            }
        }
    }
}

fun stringInterpreter(str: List<Format>) = str.fold(""){
    acc, format ->
    when (format) {
        is Print -> acc + format.text
        else -> acc + "\n"
    }
}

fun main(args: Array<String>) {
    unsafeInterpreter(string)
    print(stringInterpreter(string))
}