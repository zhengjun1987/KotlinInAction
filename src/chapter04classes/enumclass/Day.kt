package chapter04classes.enumclass

enum class Day {
    SUN,MON,TUE,WED,THU,FRI,SAT
}

fun schedule(day: Day): String {
    val s = when (day) {
        Day.MON -> "work"
        Day.TUE -> "work"
        Day.FRI,Day.SAT -> "work"
        else -> "study"
    }

    return s
}

fun main() {
    println("schedule(Day.SAT) = ${schedule(Day.SAT)}")
}