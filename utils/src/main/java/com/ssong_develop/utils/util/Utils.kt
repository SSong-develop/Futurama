package com.ssong_develop.utils.util

import android.graphics.Bitmap
import androidx.annotation.Px

object Utils {
    fun calculateAllocationByteCount(@Px width: Int, @Px height: Int, config: Bitmap.Config?): Int {
        return width * height * config.bytesPerPixel
    }


}