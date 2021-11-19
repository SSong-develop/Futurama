package com.ssong_develop.presentation.bindings

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object ImageViewBinding {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun bindImageView(view : AppCompatImageView , imageUrl : String) {
        Glide.with(view.context)
            .load(imageUrl)
            .into(view)
    }
}