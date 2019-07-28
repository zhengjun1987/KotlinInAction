package chapter03functions

/**
 * Created by zhengjun
 * Date: 2019/7/28
 * Mail:zhengjun1987@outlook.com
 */
interface Flyer {
    val speed: Int//在接口内部不允许初始化抽象属性
        get() = 1000

    fun kind()
    fun fly() {
        println("Flyer:" + this)
    }
}

class Bird(val weight: Double = 500.0,
           val color: String = "blue",
           val age: Int = 1) {

    init {
        println("this = ${this}")
    }

//    static {}

    fun fly() {}

    override fun toString(): String {
        return "Bird(weight=$weight, color='$color', age=$age)"
    }
}

fun main(args: Array<String>) {
    val blackBird = Bird(color = "black")
    val redBird = Bird(weight = 1000.0, color = "#FF00000")
    val blueBird = Bird()
    println("blueBird = ${blueBird.color}")

    val fatBird = Bird(1000.0, "#0000FF")

    val airCraft = AirCraft(speed = 1000, weight = 400.0)
    Thread.sleep(100)
//    airCraft.color = "YELLOW"
//    println("airCraft = ${airCraft.color}")
    airCraft.printVolume()
}

class AirCraft(weight: Double, speed: Int, color: String = "DEFAULT_COLOR") {
    val color: String? by lazy {
        println("Lazy initing 'color':")
//        println("this.speed = ${this.speed}")
        if (speed >= 1000) "GRAY" else "DARK_GRAY"
    }
    val weight: Double
    val speed: Int
    lateinit var volume: String

    fun printVolume() {
        volume = if (speed > 1000) "1200" else "500"
        println("this = ${this.volume}")
    }

    override fun toString(): String {
        return "AirCraft(weight=$weight, speed=$speed')"
    }

    init {
        this.weight = weight
        this.speed = speed
//        this.color = if (speed >= 1000) "GRAY" else "DARK_GRAY"
        println("this = ${this}")
    }


}