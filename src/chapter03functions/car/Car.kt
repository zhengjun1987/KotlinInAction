package chapter03functions.car

class BMWCar (val name:String){
    private val bmwEngine:Engine= Engine("BMW")

    fun getEngine():String = bmwEngine.getEngineType()
}

internal open class Engine(val type:String){
    open fun getEngineType():String = "The engine type is $type"
}

private class BenzEngine(type: String):Engine(type)

fun main() {
    val bmwCar = BMWCar("320i")
    println("bmwCar.getEngine() = ${bmwCar.getEngine()}")
}