package chapter09design_patterns.decorator

interface MacBook {
    fun getCost(): Int
    fun desc(): String
    fun produceDate(): String
}

class MacBookPro : MacBook {
    override fun getCost(): Int = 10000

    override fun desc(): String = "MacBook Pro"

    override fun produceDate(): String = "2019-08-07 08:05:24"
}

class ProcessorUpgradeMac(val macBook: MacBook) : MacBook by macBook {
    override fun getCost(): Int {
        return macBook.getCost() + 319
    }

    override fun desc(): String {
        return macBook.desc() + ", +1G Memory"
    }
}

object Printer {
    fun drawLine(){
        println("--------------------------------")
    }

    fun drawDashLine(){
        println("- - - - - - - - - - - - - - - - - ")
    }

    fun drawStars(){
        println("********************************")
    }
}

fun Printer.startDraw(decorated:Printer.() -> Unit){
    println(">>>>>>>>> start <<<<<<<<<")
    decorated()
    println(">>>>>>>>> finish <<<<<<<<<")
}

fun main(args: Array<String>) {
    val upgradeMac = ProcessorUpgradeMac(MacBookPro())
    println("upgradeMac.desc() = ${upgradeMac.desc()}")
    println("upgradeMac.getCost() = ${upgradeMac.getCost()}")
    println("upgradeMac.produceDate() = ${upgradeMac.produceDate()}")

    Printer.run {
        startDraw { drawLine() }
        startDraw { drawDashLine() }
        startDraw { drawStars() }
    }
}