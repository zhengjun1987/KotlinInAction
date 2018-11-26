package outside

import java.util.concurrent.Semaphore

val semaphore = Semaphore(1)

fun print(string: String){
    semaphore.acquire()
    println("${Thread.currentThread().name} $string")
    Thread.sleep(1000)
    semaphore.release()
}

fun main(args: Array<String>) {
    for (i in 0..100) {
        Thread(){
            run {
                print("Hello, $i")
            }
        }.start()
    }
}