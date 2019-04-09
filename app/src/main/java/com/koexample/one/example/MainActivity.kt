package com.koexample.one.example

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {


    lateinit var myPreference: SharedPreferences
    var KEY: String = "TIME"
    lateinit var welcome: TextView
    lateinit var start: Button
    var dateUtil = DateUtil()
    var oldtime: Long = -1L
    var nowtime: Long = -1L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        initDate()
        initView()
    }

    private fun initDate() {
        myPreference = getSharedPreferences("example", Context.MODE_PRIVATE)
        oldtime = myPreference.getLong(KEY, -1L)
        nowtime = dateUtil.getDate()
        myPreference.edit().putLong(KEY, nowtime)
            .commit()
        Log.d("MY", "$oldtime   $nowtime")
    }

    private fun initView() {
        welcome = findViewById(R.id.welcome)
        start = findViewById(R.id.start)
        start.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var diff = dateUtil.getDiff(oldtime, nowtime)
        when (diff) {
            -1 -> {
                welcome.setText("欢迎初次使用")
            }//首次打开
            in 0..2 -> {
                welcome.setText("欢迎经常使用")
            }//小于三天
            else -> {
                welcome.setText("好久不见，欢迎再次使用")
            }//其余情况 大于三天
        }
    }

}