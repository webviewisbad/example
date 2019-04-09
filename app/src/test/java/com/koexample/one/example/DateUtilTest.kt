package com.koexample.one.example

import org.junit.Before
import org.junit.Test
import java.util.*

class DateUtilTest {
    lateinit var datautil: DateUtil
    @Before
    fun setUp() {
        datautil = DateUtil()
    }

    @Test
    fun getDate() {
        var date = Calendar.getInstance()
        date.add(Calendar.DAY_OF_YEAR, 3)
        var time = date.time.time
        println("当前时间" + time + "  " + datautil.getDate())
    }

    @Test
    fun getDiff() {
        var date = Calendar.getInstance()
        var time = date.time.time
        date.add(Calendar.DAY_OF_YEAR, 3)
        var time1 = date.time.time
        println("时间差" + datautil.getDiff(time, time1))
    }
}