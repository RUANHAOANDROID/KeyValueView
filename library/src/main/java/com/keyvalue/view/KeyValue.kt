package com.keyvalue.view

/**
 * item data
 * 数据和细分样式
 */

data class KeyValue(
    var key1: String, val value1: String,
    var key2: String? = null, val value2: String? = null,
    var entity:Any?=null,
    var key1Style:KeyStyle =KeyStyle(),
    var key2Style:KeyStyle =KeyStyle(),
    var value1Style:ValueStyle =ValueStyle(),
    var value2Style:ValueStyle =ValueStyle(),
)