package com.unistrong.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat

class KeyValueView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    var data = mutableListOf<KeyValue>(
        KeyValue("key1", "value1"),
        KeyValue("key1", "value1", "key2", "value2")
    )
    private var textPaint: TextPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)
    var keyStyle = KeyStyle()
    var valueStyle = ValueStyle()
    var itemStyle = ItemStyle()
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val layoutHeight =
             dip2px(data.size * (itemStyle.height + itemStyle.paddingTop + itemStyle.paddingBottom + keyStyle.paddingTop + keyStyle.paddingBottom) + paddingTop + paddingBottom)
                .toInt();
        setMeasuredDimension(widthMeasureSpec, layoutHeight)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val itemHeight =  dip2px(itemStyle.height)
        var key1StartX = paddingLeft +  dip2px(keyStyle.paddingLeft)
        var key1StartY =
             dip2px(keyStyle.paddingTop + paddingTop + itemStyle.paddingTop)
        var key2StartX = width * itemStyle.percentage +  dip2px(itemStyle.paddingLeft)

        data.forEachIndexed { index, text ->
            key1StartY += itemHeight +  dip2px(keyStyle.paddingTop)
            if (index == 0)
                key1StartY =
                     dip2px(keyStyle.paddingTop + paddingTop + itemStyle.paddingTop) + itemHeight / 2

            textPaint.apply {
                textSize =  dip2px(keyStyle.textSize)
                color = ContextCompat.getColor(context, keyStyle.textColor)
            }
            canvas.drawText(
                text.key1,
                key1StartX,
                key1StartY,
                textPaint
            )
            val key1Width = textPaint.measureText(text.key1)
            textPaint.apply {
                textSize =  dip2px(valueStyle.textSize)
                color = ContextCompat.getColor(context, valueStyle.textColor)
            }
            canvas.drawText(
                text.value1,
                key1StartX + key1Width +  dip2px(valueStyle.paddingLeft),
                key1StartY,
                textPaint
            )
            text.key2?.let { key ->
                textPaint.apply {
                    textSize = dip2px(keyStyle.textSize)
                    color = ContextCompat.getColor(context, keyStyle.textColor)
                }
                canvas.drawText(
                    key,
                    key2StartX,
                    key1StartY,
                    textPaint
                )
                val key2Width = textPaint.measureText(key)
                text.value2?.let {
                    textPaint.apply {
                        textSize =  dip2px(valueStyle.textSize)
                        color = ContextCompat.getColor(context, valueStyle.textColor)
                    }
                    val value2X =
                        key2StartX + key2Width +  dip2px(valueStyle.paddingLeft)
                    val value2Y = key1StartY
                    canvas.drawText(
                        it,
                        value2X,
                        value2Y,
                        textPaint
                    )
                }
            }

            canvas.save()
        }

    }
}

data class KeyStyle(
    var textColor: Int = android.R.color.black,
    var textSize: Float = 14f,
    var paddingLeft: Float = 0f,
    var paddingRight: Float = 0f,
    var paddingTop: Float = 8f,
    var paddingBottom: Float = 0f
)

data class ItemStyle(
    var height: Float = 20f,
    var paddingLeft: Float = 0f,
    var paddingRight: Float = 0f,
    var paddingTop: Float = 0f,
    var paddingBottom: Float = 0f,
    var percentage: Float = 1f / 2//value起始位置比例默认从正中间（percentage>0.5并且<1>）
)

data class ValueStyle(
    var textColor: Int = android.R.color.darker_gray,
    var textSize: Float = 14f,
    var paddingLeft: Float = 2f,
    var paddingRight: Float = 0f,
    var paddingTop: Float = 8f,
    var paddingBottom: Float = 0f
)

data class KeyValue(
    var key1: String, val value1: String,
    var key2: String? = null, val value2: String? = null,
    var entity:Any?=null
)

fun View.dip2px(dpValue: Float): Float {
    val scale: Float = context.resources.displayMetrics.density
    return (dpValue * scale + 0.5f)
}

fun View.px2dip(pxValue: Float): Float {
    val scale: Float = context.resources.displayMetrics.density;
    return (pxValue / scale + 0.5f)
}