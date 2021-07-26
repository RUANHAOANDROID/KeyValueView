package com.unistrong.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val keyValueView = findViewById<KeyValueView>(R.id.keyValueView)
        keyValueView.data = mutableListOf(
            KeyValue("姓名：", "张三", "年龄：", "22"),
            KeyValue("身份证号码：", "115415612484215984"),
            KeyValue("家庭住址：", "黄头高坡坡北石头凹村"),
            KeyValue("婚姻状况：", "已婚", "配偶：", "李小凤"),
            KeyValue("联系电话：", "18898866988"),
        )
        keyValueView.itemStyle.apply {
            height = 30f
            percentage = 0.6f
        }
        keyValueView.keyStyle.apply {
            textColor = android.R.color.holo_red_dark
            textSize = 16f
        }
        keyValueView.valueStyle.apply {
            textColor = android.R.color.holo_blue_dark
            textSize = 16f
        }
        keyValueView.invalidate()
    }
}
