package chapter09design_patterns.builder

class Robot constructor(
        val code: String,
        val battery: String? = null,
        val height: Int? = null,
        val weight: Int? = null
) {
    init {
        require(weight == null || battery != null) {
            "Battery should be determined when setting weight."
        }
    }

    class Builder(val code: String) {
        var battery: String? = null
        var height: Int? = null
        var weight: Int? = null

        //此处省略各种返回构造器本身的set方法，以及最终的build方法
    }
}

fun main(args: Array<String>) {
    val r007 = Robot(code = "007", battery = "R6")
    val r9527 = Robot(code = "9527")
}