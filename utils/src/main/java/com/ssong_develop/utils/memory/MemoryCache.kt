package com.ssong_develop.utils.memory

import android.graphics.Bitmap
import android.os.Parcelable

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

    }

}