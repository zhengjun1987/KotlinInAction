package chapter09design_patterns.observer

import java.util.*
import kotlin.properties.Delegates

class StockUpdate : Observable() {
    val observers = mutableListOf<Observer>()
    fun onStockChanged(price:Int){
        observers.forEach {
            it.update(this,price)
        }
    }
}

class StockDisplay :Observer {
    override fun update(p0: Observable?, p1: Any?) {
        if (p0 is StockUpdate) {
            println("The latest stock price is $p1")
        }
    }
}

interface StockPriceListener {
    fun onRise(price: Int)
    fun onFail(price: Int)
}

class StockObserver :StockPriceListener{
    override fun onRise(price: Int) {
        println("The latest price has risen to $price")
    }

    override fun onFail(price: Int) {
        println("The latest price has fallen to $price")
    }
}

class StockObservable {
    val listeners = mutableListOf<StockPriceListener>()
    var price:Int by Delegates.observable(0){
        _, old, new ->
        listeners.forEach {
            if (new > old) it.onRise(price) else it.onFail(price)
        }
    }
}

fun main(args: Array<String>) {
    val stockUpdate = StockUpdate()
    val stockDisplay = StockDisplay()
    stockUpdate.observers += stockDisplay
    stockUpdate.onStockChanged(100)

    val stockObservable = StockObservable()
    val stockObserver = StockObserver()
    stockObservable.listeners += stockObserver
    stockObservable.price = 98
    stockObservable.price = 95
}