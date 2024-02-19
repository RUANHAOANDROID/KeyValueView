package com.keyvalue.view

/**
 * Item或单个试图整体样式
 */

data class ItemStyle(
    var height: Float = 20f,
    var paddingLeft: Float = 0f,
    var paddingRight: Float = 0f,
    var paddingTop: Float = 0f,
    var paddingBottom: Float = 0f,
    var percentage: Float = 1f / 2//value起始位置比例默认从正中间（percentage>0.5并且<1>）
)

class ItemStyleBuilder {
    var height: Float = 20f
    var paddingLeft: Float = 0f
    var paddingRight: Float = 0f
    var paddingTop: Float = 0f
    var paddingBottom: Float = 0f
    var percentage: Float = 1f / 2 // value起始位置比例默认从正中间（percentage>0.5并且<1>）

    fun build(): ItemStyle {
        return ItemStyle(
            height,
            paddingLeft,
            paddingRight,
            paddingTop,
            paddingBottom,
            percentage
        )
    }
}

fun itemStyle(block: ItemStyleBuilder.() -> Unit): ItemStyle {
    val builder = ItemStyleBuilder()
    builder.block()
    return builder.build()
}