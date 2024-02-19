package com.keyvalue.view

/**
 * item data
 * 数据和细分样式
 */

data class KeyValue(
    var key1: String, val value1: String,
    var key2: String? = null, val value2: String? = null,
    var entity: Any? = null,
    var key1Style: KeyStyle = KeyStyle(),
    var key2Style: KeyStyle = KeyStyle(),
    var value1Style: ValueStyle = ValueStyle(),
    var value2Style: ValueStyle = ValueStyle(),
)

class KeyValueBuilder {
    var key1: String = ""
    var value1: String = ""
    var key2: String? = null
    var value2: String? = null
    var entity: Any? = null
    var key1Style: KeyStyle = KeyStyle()
    var key2Style: KeyStyle = KeyStyle()
    var value1Style: ValueStyle = ValueStyle()
    var value2Style: ValueStyle = ValueStyle()
    fun build(): KeyValue {
        return KeyValue(
            key1,
            value1,
            key2,
            value2,
            entity,
            key1Style,
            key2Style,
            value1Style,
            value2Style
        )
    }
}

fun kevValue(block: KeyValueBuilder.() -> Unit): KeyValue {
    val builder = KeyValueBuilder()
    builder.block()
    return builder.build()
}