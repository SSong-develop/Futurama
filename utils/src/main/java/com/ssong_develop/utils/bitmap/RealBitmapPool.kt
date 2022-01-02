package com.ssong_develop.utils.bitmap

import android.graphics.Bitmap

/**
 * A [BitmapPool] implementation that uses a [BitmapPoolStrategy] to bucket [Bitmap]s
 */
class RealBitmapPool: BitmapPool {
    override fun put(bitmap: Bitmap) {
        TODO("Not yet implemented")
    }

    override fun get(width: Int, height: Int, config: Bitmap.Config): Bitmap {
        TODO("Not yet implemented")
    }

    override fun getOrNull(width: Int, height: Int, config: Bitmap.Config): Bitmap? {
        TODO("Not yet implemented")
    }

    override fun getDirty(width: Int, height: Int, config: Bitmap.Config): Bitmap {
        TODO("Not yet implemented")
    }

    override fun getDirtyOrNull(width: Int, height: Int, config: Bitmap.Config): Bitmap? {
        TODO("Not yet implemented")
    }

    override fun trimMemory(level: Int) {
        TODO("Not yet implemented")
    }

    override fun clear() {
        TODO("Not yet implemented")
    }
}