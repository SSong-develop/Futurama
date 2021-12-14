package com.ssong_develop.utils

import java.io.InputStream
import java.io.OutputStream

object Utils {

    @JvmStatic
    fun copyStream(inputStream : InputStream, outputStream : OutputStream) {
        val bufferSize = 1024
        try{
            val bytes = ByteArray(bufferSize)
            while(true){
                val count = inputStream.read(bytes,0,bufferSize)
                if(count == -1)
                    break
                outputStream.write(bytes,0,count)
            }
        }catch (exception : Exception){

        }
    }
}