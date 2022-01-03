package com.ssong_develop.utils.memory

import android.graphics.Bitmap
import android.os.Parcelable
import com.ssong_develop.utils.size.Size
import kotlinx.parcelize.Parcelize

/**
 * An in-memory cache of recently loaded images.
 */
interface MemoryCache {

    /** The current size of the cache in bytes. */
    val size: Int

    val maxSize: Int

    operator fun get(key: Key): Bitmap?

    /** The cache key for an image in the memory cache. */
    sealed class Key : Parcelable {

        companion object {
            /** Create a simple memory cache key. */
            @JvmStatic
            @JvmName("create")
            operator fun invoke(value: String): Key = Simple(value)
        }

        /** A Simple memory cache key that wraps a [String]. Create new instances using [invoke] */
        @Parcelize
        internal data class Simple(val value: String): Key()

        @Parcelize
        internal data class Complex(
            val base: String,
            val transformations: List<String>,
            val size: Size?,
            val parameters: Map<String,String>
        ) : Key()
    }

}