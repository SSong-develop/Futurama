package com.ssong_develop.utils.memory

internal interface WeakMemoryCache {

    fun get(key: Key) : RealMemoryCache.Value?

}