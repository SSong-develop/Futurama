package com.ssong_develop.presentation.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ssong_develop.domain.entities.Characters
import com.ssong_develop.presentation.databinding.ItemCharacterBinding

class CharacterViewHolder(
    private val binding: ItemCharacterBinding,
    private val delegate: Delegate
) : RecyclerView.ViewHolder(binding.root), View.OnClickListener, View.OnLongClickListener {
    private lateinit var character: Characters

    init {
        binding.root.setOnClickListener(this)
        binding.root.setOnLongClickListener(this)
    }

    interface Delegate {
        fun onItemClick(view: View, character: Characters)
    }

    fun bind(data: Characters) {
        character = data
        binding.apply {
            character = data
            executePendingBindings()
        }
    }

    override fun onClick(view: View) {
        delegate.onItemClick(binding.image, character)
    }

    override fun onLongClick(view : View): Boolean = false
}