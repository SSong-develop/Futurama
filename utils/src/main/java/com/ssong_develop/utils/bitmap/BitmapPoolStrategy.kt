package com.ssong_develop.utils.bitmap

import android.graphics.Bitmap
import android.os.Build.VERSION.SDK_INT
import androidx.annotation.Px
import androidx.annotation.RequiresApi

internal interface BitmapPoolStrategy {

    companion object {
        operator fun invoke(): BitmapPoolStrategy {
            return when {
                SDK_INT >= 19 -> SizeStrategy()
                else -> AttributeStrategy()
            }
        }
    }

    /** Add [bitmap] to the LRU Cache. */
    fun put(bitmap: Bitmap)

    /** Return a reusable bitmap matching [width], [height], and [config]. Return null if there is no match. */
    fun get(@Px width: Int, @Px height: Int, config: Bitmap.Config): Bitmap?

    /** Remove the least recently used bitmap from the cache and return it. */
    fun removeLast(): Bitmap?

    /** Return a string representation of [bitmap] */
    fun stringify(bitmap: Bitmap): String

    /** Return a string representation of a bitmap matching [width], [height], and [config]. */
    fun stringify(@Px width: Int, @Px height: Int, config: Bitmap.Config): String
}

@RequiresApi(19)
internal class SizeStrategy : BitmapPoolStrategy {

    override fun put(bitmap: Bitmap) {
        TODO("Not yet implemented")
    }

    override fun get(width: Int, height: Int, config: Bitmap.Config): Bitmap? {
        TODO("Not yet implemented")
    }

    override fun removeLast(): Bitmap? {
        TODO("Not yet implemented")
    }

    override fun stringify(bitmap: Bitmap): String {
        TODO("Not yet implemented")
    }

    override fun stringify(width: Int, height: Int, config: Bitmap.Config): String {
        TODO("Not yet implemented")
    }

}

internal class AttributeStrategy : BitmapPoolStrategy {
    override fun put(bitmap: Bitmap) {
        TODO("Not yet implemented")
    }

    override fun get(width: Int, height: Int, config: Bitmap.Config): Bitmap? {
        TODO("Not yet implemented")
    }

    override fun removeLast(): Bitmap? {
        TODO("Not yet implemented")
    }

    override fun stringify(bitmap: Bitmap): String {
        TODO("Not yet implemented")
    }

    override fun stringify(width: Int, height: Int, config: Bitmap.Config): String {
        TODO("Not yet implemented")
    }

}