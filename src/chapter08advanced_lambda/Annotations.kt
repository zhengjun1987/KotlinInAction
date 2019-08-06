package chapter08advanced_lambda

import java.text.Annotation
import javax.annotation.processing.*
import javax.lang.model.element.TypeElement

annotation class FooAnnotation(val bar:String)

annotation class Cache(val namespace:String,val expires:Int)
annotation class CacheKey(val keyName:String,val buckets:IntArray)

@Cache(namespace = "hero",expires = 3600)
data class Hero(
        @CacheKey(keyName = "heroName",buckets = intArrayOf(1,2,3))
        val name:String,
        val attack:Int,
        val defense:Int,
        val initHp:Int
)

fun main(args: Array<String>) {
        val cache = Hero::class.annotations.find { it is Cache } as Cache?
        println("cache?.namespace = ${cache?.namespace}")
        println("cache?.expires = ${cache?.expires}")
}

//        annotation class MapperAnnotation
//
//        class MapperProcess : AbstractProcessor() {
//                override fun process(mutableSet: MutableSet<out TypeElement>?, environment: RoundEnvironment?): Boolean {
//                        environment?.getElementsAnnotatedWith(MapperProcess::class.java)?.firstOrNull
//                        val javaFileObject = processingEnv.filer.createSourceFile("Mapper")
//                }
//        }