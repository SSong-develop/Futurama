package com.ssong_develop.utils.bitmap

import android.graphics.Bitmap
import com.ssong_develop.utils.memory.WeakMemoryCache
import java.util.logging.Logger

/**
 * Count references to [Bitmap]s and add them to a [BitmapPool] when they're no longer referenced
 *
 * [Bitmap]에 대한 참조 수를 세고 더 이상 참조가 없을 때 [BitmapPool]에 추가.
 */
internal interface BitmapReferenceCounter {

    fun increment(bitmap: Bitmap)

    fun decrement(bitmap: Bitmap): Boolean

    fun setValid(bitmap: Bitmap, isValid: Boolean)
}

internal object EmptyBitmapReferenceCounter : BitmapReferenceCounter {
    override fun increment(bitmap: Bitmap) {}

    override fun decrement(bitmap: Bitmap): Boolean = false

    override fun setValid(bitmap: Bitmap, isValid: Boolean) {}
}

internal class RealBitmapReferenceCounter(
    private val weakMemoryCache: WeakMemoryCache,
    private val bitmapPool: BitmapPool,
    private val logger: Logger?
) : BitmapReferenceCounter {
    override fun increment(bitmap: Bitmap) {
        TODO("Not yet implemented")
    }

    override fun decrement(bitmap: Bitmap): Boolean {
        TODO("Not yet implemented")
    }

    override fun setValid(bitmap: Bitmap, isValid: Boolean) {
        TODO("Not yet implemented")
    }

}