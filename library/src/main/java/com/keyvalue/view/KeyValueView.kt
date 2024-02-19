package com.keyvalue.view

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
        val lineHeight =
            itemStyle.height + itemStyle.paddingTop + itemStyle.paddingBottom + keyStyle.paddingTop + keyStyle.paddingBottom
        var spanLineCount = 0
        data.forEach { spanLineCount += it.value1Style.spanLines }
        val layoutHeight =
            dip2px((data.size + spanLineCount) * lineHeight + paddingTop + paddingBottom).toInt();
        setMeasuredDimension(widthMeasureSpec, layoutHeight)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val itemHeight = dip2px(itemStyle.height)
        var key1StartX = paddingLeft + dip2px(keyStyle.paddingLeft)
        var key1StartY = dip2px(keyStyle.paddingTop + paddingTop + itemStyle.paddingTop)

        var key2StartX = width * itemStyle.percentage + dip2px(itemStyle.paddingLeft)

        var extraLineHeight = 0f //额外行高，有时候占两行

        data.forEachIndexed { index, text ->
            key1StartY += itemHeight + dip2px(keyStyle.paddingTop) + extraLineHeight
            if (index == 0)
                key1StartY =
                    dip2px(keyStyle.paddingTop + paddingTop + itemStyle.paddingTop) + itemHeight / 2
            //初始化画笔
            textPaint.apply {
                textSize = dip2px(text.key1Style.textSize)
                color = ContextCompat.getColor(context, text.key1Style.textColor)
            }
            //draw key1
            canvas.drawText(
                text.key1,
                key1StartX,
                key1StartY,
                textPaint
            )

            var key1Width = textPaint.measureText(text.key1)
            key1Width= maxOf(key1Width,keyStyle.minWidth)
            textPaint.apply {
                textSize = dip2px(text.value1Style.textSize)
                color = ContextCompat.getColor(context, text.value1Style.textColor)
            }
            /**
             *value1
             *value1支持跨行显示,但不能有key2和value2
             *示例 KeyValue("key1：", "value1", value1Style = ValueStyle(spanLines = 1))
             */

            val value1RemainingWidth =
                canvas.width - (key1StartX + key1Width + dip2px(text.value1Style.paddingLeft))//value1剩余空间
            val singleTextWidth = textPaint.measureText(text.value1.first().toString())//单个字宽度
            val textLineWidth = textPaint.measureText(text.value1)//字行宽
            val isExtraLine = textLineWidth > value1RemainingWidth
            if (isExtraLine) {//需要换行
                extraLineHeight += itemHeight
                val nextLineIndex = (value1RemainingWidth / singleTextWidth).toInt()//换行位置
                val str1 = text.value1.substring(0, nextLineIndex)
                val str2 = text.value1.substring(nextLineIndex + 1, text.value1.length)

                canvas.drawText(
                    str1,
                    key1StartX + key1Width + dip2px(text.value1Style.paddingLeft),
                    key1StartY,
                    textPaint
                )
                canvas.drawText(
                    str2,
                    key1StartX + dip2px(text.value1Style.paddingLeft),
                    key1StartY + itemHeight,
                    textPaint
                )
            } else {
                canvas.drawText(
                    text.value1,
                    key1StartX + key1Width + dip2px(text.value1Style.paddingLeft),
                    key1StartY,
                    textPaint
                )
            }

            //key2
            text.key2?.let { key ->
                textPaint.apply {
                    textSize = dip2px(text.key2Style.textSize)
                    color = ContextCompat.getColor(context, text.key2Style.textColor)
                }
                canvas.drawText(
                    key,
                    key2StartX,
                    key1StartY,
                    textPaint
                )
                var key2Width = textPaint.measureText(key)
                key2Width= maxOf(key2Width,keyStyle.minWidth)
                //value2
                text.value2?.let {
                    textPaint.apply {
                        textSize = dip2px(text.value2Style.textSize)
                        color = ContextCompat.getColor(context, text.value2Style.textColor)
                    }
                    val value2X =
                        key2StartX + key2Width + dip2px(text.value2Style.paddingLeft)
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

    private fun View.dip2px(dpValue: Float): Float {
        val scale: Float = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f)
    }

    fun px2dip(pxValue: Float): Float {
        val scale: Float = context.resources.displayMetrics.density;
        return (pxValue / scale + 0.5f)
    }
}

