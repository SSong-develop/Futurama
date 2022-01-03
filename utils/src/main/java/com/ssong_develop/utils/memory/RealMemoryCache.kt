package com.ssong_develop.utils.memory

import android.graphics.Bitmap

internal class RealMemoryCache(

){
    interface Value {
        val bitmap : Bitmap
        val isSampled: Boolean
    }
}