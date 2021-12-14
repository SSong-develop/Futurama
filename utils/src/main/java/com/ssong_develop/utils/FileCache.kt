package com.ssong_develop.utils

import android.content.Context
import java.io.File

// TODO : 구조 분석 및 캐시 과정 설명할 수 있도록 이해하기!
class FileCache(context : Context) {

    private val cacheDir : File = context.cacheDir

    init {

        if(!cacheDir.exists()) cacheDir.mkdir()
    }

    fun getFile(url : String) : File {
        val filename = url.hashCode().toString()
        return File(cacheDir,filename)
    }

    fun clear() {
        val files = cacheDir.listFiles() ?: return
        for(f in files) f.delete()
    }
}