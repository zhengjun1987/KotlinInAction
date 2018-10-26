package chapter02basis

import java.io.BufferedReader
import java.io.StringReader
import java.lang.NumberFormatException

fun readNumber(reader: BufferedReader): Int? = try {
    val readLine = reader.readLine()
    Integer.parseInt(readLine)
} catch (e: Exception) {
    e.printStackTrace()
    null
} finally {
    reader.close()
}

fun main(args: Array<String>) {
    println("readNumber(BufferedReader(StringReader(\"239\"))) = ${readNumber(BufferedReader(StringReader("239")))}")
    println("readNumber(BufferedReader(StringReader(\"Not a number\"))) = ${readNumber(BufferedReader(StringReader("Not a number")))}")
}