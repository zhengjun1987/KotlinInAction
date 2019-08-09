package chapter11asynchronous_concurrence

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.text.SimpleDateFormat

object PrintUtils {
    fun print(string: String){
        val date = SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(System.currentTimeMillis())
        kotlin.io.print("$date [${Thread.currentThread().name}] -- $string")
    }
}

fun main() = runBlocking {
    val job = launch {
        search()
    }
    PrintUtils.print("Hello,")
    job.join()
}

suspend fun search(){
    delay(2000L)
    print("World!\n")
    PrintUtils.print("End of search()")
}