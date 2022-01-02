package com.ssong_develop.utils.util

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable

internal fun Bitmap.toDrawable(resources : Resources) : BitmapDrawable = BitmapDrawable(resources,this)