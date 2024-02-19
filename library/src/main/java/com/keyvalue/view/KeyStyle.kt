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
class KeyStyleBuilder {
    var textColor: Int = android.R.color.black
    var textSize: Float = 14f
    var paddingLeft: Float = 0f
    var paddingRight: Float = 0f
    var paddingTop: Float = 8f
    var paddingBottom: Float = 0f
    var minWidth: Float = 0f

    fun build(): KeyStyle {
        return KeyStyle(
            textColor,
            textSize,
            paddingLeft,
            paddingRight,
            paddingTop,
            paddingBottom,
            minWidth
        )
    }
}
fun keyStyle(block: KeyStyleBuilder.() -> Unit): KeyStyle {
    val builder = KeyStyleBuilder()
    builder.block()
    return builder.build()
}