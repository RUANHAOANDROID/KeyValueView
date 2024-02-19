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

class ValueStyleBuilder {
    var textColor: Int = android.R.color.darker_gray
    var textSize: Float = 14f
    var paddingLeft: Float = 2f
    var paddingRight: Float = 0f
    var paddingTop: Float = 8f
    var paddingBottom: Float = 0f
    var spanLines: Int = 0 // 默认不跨行

    fun build(): ValueStyle {
        return ValueStyle(
            textColor,
            textSize,
            paddingLeft,
            paddingRight,
            paddingTop,
            paddingBottom,
            spanLines
        )
    }
}

fun valueStyle(block: ValueStyleBuilder.() -> Unit): ValueStyle {
    val builder = ValueStyleBuilder()
    builder.block()
    return builder.build()
}