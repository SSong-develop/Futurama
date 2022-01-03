package com.ssong_develop.utils.memory

internal interface WeakMemoryCache {

    fun get(key: MemoryCache.Key) : RealMemoryCache.Value?

}