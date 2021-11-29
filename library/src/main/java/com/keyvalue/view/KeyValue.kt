package com.keyvalue.view

/**
 * item data
 */
data class KeyValue(
    var key1: String, val value1: String,
    var key2: String? = null, val value2: String? = null,
    var entity:Any?=null
)