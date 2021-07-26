package com.unistrong.myapplication

import android.content.Context
import android.view.View


fun View.dip2px(dpValue: Float): Float {
    val scale: Float = context.resources.displayMetrics.density
    return (dpValue * scale + 0.5f)
}

fun View.px2dip(pxValue: Float): Float {
    val scale: Float = context.resources.displayMetrics.density;
    return (pxValue / scale + 0.5f)
}
