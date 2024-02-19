package com.keyvalue.view

/**
 * Item或单试图中key样式
 */
data class KeyStyle(
    var textColor: Int = android.R.color.black,
    var textSize: Float = 14f,
    var paddingLeft: Float = 0f,
    var paddingRight: Float = 0f,
    var paddingTop: Float = 8f,
    var paddingBottom: Float = 0f,
    var minWidth: Float = 0f
)