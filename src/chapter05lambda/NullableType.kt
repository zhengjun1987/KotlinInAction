package chapter05lambda

val x: Long? = null

data class Glasses(val myopia:Double)
data class Student(val glasses: Glasses?)
data class Seat(val student: Student?)

fun main() {
    val seat = Seat(null)
    val myopia = seat.student?.glasses?.myopia ?: 0.0
    println("seat.student?.glasses?.myopia = $myopia")

    val s = "hello,world!"
    s.let {
//        it[0] = "H"
    }
    println("s = ${s}")


    val stu:Any = Student(Glasses(200.0))
    if (stu is Student) {
        println("student.glasses?.myopia = ${stu.glasses?.myopia ?: 0.0}")
    }

    println("1344 as? String = ${1344 as? String ?: "Uncastable"}")
    val cast = cast<String>(140163L)
    println("cast = ${cast}")
}

inline fun <reified T> cast(original:Any):T? = original as? T