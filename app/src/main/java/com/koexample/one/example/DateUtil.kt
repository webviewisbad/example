package com.koexample.one.example


class DateUtil {

    /*
     获取当前时间
     */
    fun getDate(): Long {
        var time = System.currentTimeMillis()
        return time
    }

    /*
     获取时间差
     */
    fun getDiff(oldtime: Long, newtime: Long): Int {
        if (oldtime > 0L && newtime > 0L) {
            var diff = newtime - oldtime
            return (diff / (1000 * 24 * 60 * 60)).toInt()
        } else {
            return -1
        }
    }
}