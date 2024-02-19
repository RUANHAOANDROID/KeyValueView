package com.unistrong.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.keyvalue.view.KeyValueView
import com.keyvalue.view.kevValue
import com.keyvalue.view.valueStyle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val keyValueView = findViewById<KeyValueView>(R.id.keyValueView)
        keyValueView.data = mutableListOf(
            kevValue {
                key1 = "姓名"
                value1 = "张三"
                key2 = "年龄"
                value2 = "22"
            },
            kevValue {
                key1 = "身份证号码"
                value1 = "115415612484215984"
            },
            kevValue {
                key1 = "家庭住址"
                value1 = "黄头高坡坡北石头凹村"
            },
            kevValue {
                key1 = "婚姻状况"
                value1 = "已婚"
                key2 = "配偶"
                value2 = "李小凤"
            },
            kevValue {
                key1 = "联系电话"
                value1 = "18898866988"
            },
            kevValue {
                key1 = "描述"
                value1 = "这是一个怪怪的人"
                value2Style = valueStyle {
                    textColor = R.color.black
                }
            }
        )
        keyValueView.itemStyle.apply {
            height = 30f
            percentage = 0.6f
        }
        keyValueView.keyStyle.apply {
            textColor = android.R.color.holo_red_dark
            textSize = 16f
            minWidth = 100f
        }
        keyValueView.valueStyle.apply {
            textColor = android.R.color.holo_blue_dark
            textSize = 16f
        }
        keyValueView.invalidate()
    }
}
