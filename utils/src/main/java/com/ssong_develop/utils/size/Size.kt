package com.ssong_develop.utils.size

import android.os.Parcelable
import androidx.annotation.Px
import kotlinx.parcelize.Parcelize

/**
 * Represents the target size of an image request.
 *
 */
sealed class Size : Parcelable

/** Represents the width and height of the source image. */
@Parcelize
object OriginalSize : Size() {
    override fun toString(): String = "coil.size.OriginalSize"
}

/** A positive width and height in pixels */
@Parcelize
data class PixelSize(
    @Px val width: Int,
    @Px val height: Int
) : Size() {

    init {
        require(width > 0 && height > 0) { "width and height must be > 0." }
    }
}
