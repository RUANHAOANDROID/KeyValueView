package com.keyvalue.view

/**
 *全局Value样式
 */

data class ValueStyle(
    var textColor: Int = android.R.color.darker_gray,
    var textSize: Float = 14f,
    var paddingLeft: Float = 2f,
    var paddingRight: Float = 0f,
    var paddingTop: Float = 8f,
    var paddingBottom: Float = 0f,
    var spanLines :Int=0//默认不跨行
)