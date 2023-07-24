package com.chichi289.composepager

import android.util.Log

object Common {

    fun printLog(message: String, tag: String = "CHIRAG") {
        Log.e(tag, message)
    }

    enum class ScreenName(val value: String) {
        TransformationPagerDemo("TransformationPagerDemo"),
        DribbleInspirationPager("DribbleInspirationPager"),
        LineIndicatorPager("LineIndicatorPager")
    }

}