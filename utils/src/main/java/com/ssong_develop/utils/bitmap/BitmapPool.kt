package com.ssong_develop.utils.bitmap

import android.graphics.Bitmap
import androidx.annotation.Px

/**
 * An object pool that enables callers to reuse [Bitmap] objects
 */
interface BitmapPool {

    companion object {
        /**
         *
         * Create a new [BitmapPool]
         *
         * @param maxSize The maximum size of the pool in bytes
         */
        @JvmStatic
        @JvmName("create")
        operator fun invoke(maxSize: Int): BitmapPool {
            return if (maxSize == 0) EmptyBitmapPool() else RealBitmapPool()
        }
    }

    /**
     * Add the given [Bitmap] to the pool if it is eligible to be re-used and the pool can fit it
     * Otherwise, this method calls [Bitmap.recycle] on the bitmap and discards it
     *
     * 지정된 [Bitmap]을 재사용할 수 있고, Pool이 이를 수용할 수 있는 경우, Pool에 추가
     * 그렇지 않다면, 이 메서드는 [Bitmap.recycle]을 호출합니다. 비트맵에서 재활용하고 폐기한다.
     *
     * Callers **must not** continue to use the bitmap after calling this method
     *
     * 호출자는 이 메서드를 호출한 후 비트맵을 계속 사용하면 안된다.
     */
    fun put(bitmap: Bitmap)

    /**
     * Return a [Bitmap] of exactly the given width, height, and configuration, and containing only transparent pixels
     *
     * 지정된 너비, 높이 및 구성의 비트맵을 반환, 투평한 픽셀만 포함한다.
     *
     * If no bitmap with the requested attributes is present in the pool, a new one will be allocated.
     *
     * 요청한 특성을 가진 비트맵이 풀에 존재하지 않는다면, 새 비트맵이 할당된다.
     *
     * Because this method erases all pixels in the [Bitmap], this method is slightly slower
     * than [getDirty]. If the [Bitmap] is being obtained to be used in [BitmapFactory]
     * or in any other case where every pixel in the [Bitmap] will always be overwritten or cleared,
     * [getDirty] will be faster. When in doubt, use this method to ensure correctness
     *
     * 이 방법은 비트맵의 모든 픽셀을 지우므로 이 방법은 [getDirty]에 비해서 느리다.
     * [BitmapFactory]에서 사용할 Bitmap을 얻는 경우, 또는 [Bitmap]의 모든 픽셀이 항상 덮어쓰거나 지워지는 다른 경우에는
     * [getDirty]가 더 빠르다. 의심스러울 경우 이 [get]메서드를 사용해 정확성을 보장해라
     */
    fun get(@Px width: Int, @Px height: Int, config: Bitmap.Config): Bitmap

    fun getOrNull(@Px width: Int, @Px height: Int, config: Bitmap.Config): Bitmap?

    fun getDirty(@Px width: Int, @Px height: Int, config: Bitmap.Config): Bitmap

    fun getDirtyOrNull(@Px width : Int, @Px height : Int, config: Bitmap.Config): Bitmap?

    fun trimMemory(level : Int)

    fun clear()
}