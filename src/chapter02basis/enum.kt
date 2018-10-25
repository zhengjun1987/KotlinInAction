package chapter02basis

import java.lang.Exception

enum class Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

enum class RGBColor(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238);

    fun rgb() = (256 * r + g) * 256 + b
}

fun main(args: Array<String>) {
    println("RGBColor.VIOLET.rgb() = ${Integer.toHexString(RGBColor.VIOLET.rgb()).toUpperCase()}")
    for (value in RGBColor.values()) {
        print(getMnemonic(value)+" ")
    }
    print("\n")
    for (value in RGBColor.values()) {
        println("$value -> ${getWarmth(value)}")
    }

    try {
        println("mix(RGBColor.RED,RGBColor.YELLOW) = ${mix(RGBColor.RED, RGBColor.YELLOW)}")
        println("mix(RGBColor.YELLOW,RGBColor.RED) = ${mix(RGBColor.YELLOW, RGBColor.RED)}")
        println("mix(RGBColor.INDIGO,RGBColor.VIOLET) = ${mix(RGBColor.INDIGO, RGBColor.VIOLET)}")
    } catch (e: Exception) {
        println("e = $e")
    }
}

fun mix(color1: RGBColor,color2: RGBColor) =
        when (setOf(color1,color2)) {
            setOf(RGBColor.RED,RGBColor.YELLOW) -> RGBColor.ORANGE
            setOf(RGBColor.YELLOW,RGBColor.BLUE) -> RGBColor.GREEN
            setOf(RGBColor.BLUE,RGBColor.VIOLET) -> RGBColor.INDIGO
            else -> throw Exception("Dirty color")
        }

fun getMnemonic(color: RGBColor) =
        when (color) {
            RGBColor.RED -> "Richard"
            RGBColor.ORANGE -> "Of"
            RGBColor.YELLOW -> "York"
            RGBColor.GREEN -> "Gave"
            RGBColor.BLUE -> "Battle"
            RGBColor.INDIGO -> "In"
            RGBColor.VIOLET -> "Vain"
        }

fun getWarmth(color: RGBColor) =
        when (color) {
            RGBColor.RED,RGBColor.ORANGE,RGBColor.YELLOW -> "warm"
            RGBColor.GREEN -> "neutral"
            RGBColor.BLUE,RGBColor.INDIGO,RGBColor.VIOLET -> "cold"
        }