package chapter06types

import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 *   Author:Zheng Jun
 *   E-mail:zhengjun1987@outlook.com
 *   Date:5/11/2018 00:33
 *   Project:KotlinInAction
 */

class MyService {
    fun performAction() = "foo"
}

class MyTest {
    //    private var myService: MyService? = null
        private lateinit var myService: MyService

    @Before
    fun setUp() {
        myService = MyService()
    }

    @Test
    fun testAction(){
        //NullPointerException
//        Assert.assertEquals("foo",myService!!.performAction())

        //UninitializedPropertyAccessException: lateinit property myService has not been initialized
        Assert.assertEquals("foo",myService.performAction())
    }
}

fun main(args: Array<String>) {
    val myTest = MyTest()
    myTest.testAction()
}