package com.hieupt.android.standalonescrollbar.view

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.webkit.WebView

/**
 * Created by HieuPT on 12/8/2020.
 */
class WebView2 @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : WebView(context, attrs, defStyleAttr) {

    private val drawListeners = mutableSetOf<OnDrawListener>()

    private val scrollChangeListeners = mutableSetOf<OnScrollChangedListener>()

    fun addOnDrawListener(onDrawListener: OnDrawListener) {
        drawListeners.add(onDrawListener)
    }

    fun addOnScrollListener(onScrollChangeListener: OnScrollChangedListener) {
        scrollChangeListeners.add(onScrollChangeListener)
    }

    fun calculateVerticalScrollRange(): Int = computeVerticalScrollRange()

    fun calculateVerticalScrollOffset(): Int = computeVerticalScrollOffset()

    fun calculateHorizontalScrollRange(): Int = computeHorizontalScrollRange()

    fun calculateHorizontalScrollOffset(): Int = computeHorizontalScrollOffset()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawListeners.forEach { it.onDraw(canvas) }
    }

    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        super.onScrollChanged(l, t, oldl, oldt)
        scrollChangeListeners.forEach {
            it.onScrollChanged(l, t, oldl, oldt)
        }
    }
}