package com.ssong_develop.presentation.bindings

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.ssong_develop.utils.ImageLoader

object ImageViewBinding {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun bindImageView(view : AppCompatImageView , imageUrl : String) {
        Glide.with(view.context)
            .load(imageUrl)
            .into(view)
    }

    @JvmStatic
    @BindingAdapter("imageUrlWithoutGlide")
    fun bindImageViewWithoutGlide(view : AppCompatImageView , imageUrl : String) {
        ImageLoader.instance.displayImage(imageUrl,view)
    }
}