package com.ssong_develop.utils

import android.graphics.Bitmap
import android.util.Log
import java.util.*
import kotlin.collections.LinkedHashMap

// TODO : 구조 분석 및 캐시 과정 설명할 수 있도록 이해하기!
class MemoryCache {
    private val cache = Collections.synchronizedMap(
        LinkedHashMap<String, Bitmap>(10,1.5f,true)
    )

    private var size : Long = 0
    private var limit : Long = 1000000

    init {
        setLimit(Runtime.getRuntime().maxMemory() / 4)
    }

    private fun setLimit(newLimit : Long) {
        limit = newLimit
        Log.i(TAG,"MemoryCache will use up to ${limit.toDouble() / 1024.0 / 1024.0} MB")
    }

    operator fun get(id : String) : Bitmap? {
        return try {
            if(!cache.containsKey(id)) null else cache[id]
        } catch (exception : NullPointerException) {
            exception.printStackTrace()
            null
        }
    }

    fun put(id : String, bitmap : Bitmap) {
        try {
            if(cache.containsKey(id))
                size -= getSizeInBytes(cache[id])
            cache[id] = bitmap
            size += getSizeInBytes(bitmap)
            checkSize()
        } catch (throwable : Throwable) {
            throwable.printStackTrace()
        }
    }

    private fun checkSize() {
        Log.i(TAG,"cache size= $size length ${cache.size}")
        if(size > limit) {
            val iter = cache.entries.iterator() // least recently accessed item will be the first one iterated
            while(iter.hasNext()){
                val entry = iter.next()
                size -= getSizeInBytes(entry.value)
                iter.remove()
                if(size <= limit)
                    break
            }
            Log.i(TAG,"Clean cache. New size ${cache.size}")
        }
    }

    fun clear() {
        try {
            cache.clear()
            size = 0
        } catch (exception : NullPointerException) {
            exception.printStackTrace()
        }
    }

    private fun getSizeInBytes(bitmap : Bitmap?) : Long {
        return if(bitmap == null) 0 else (bitmap.rowBytes * bitmap.height).toLong()
    }

    companion object {

        private val TAG = "MemoryCache"
    }
}