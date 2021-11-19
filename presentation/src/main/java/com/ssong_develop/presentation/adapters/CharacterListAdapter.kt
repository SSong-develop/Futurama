package com.ssong_develop.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ssong_develop.domain.entities.Characters
import com.ssong_develop.presentation.R
import com.ssong_develop.presentation.databinding.ItemCharacterBinding
import com.ssong_develop.presentation.viewholders.CharacterViewHolder

class CharacterListAdapter(
    private val delegate : CharacterViewHolder.Delegate
) : RecyclerView.Adapter<CharacterViewHolder>() {

    private val items = mutableListOf<Characters>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemCharacterBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_character, parent, false)
        return CharacterViewHolder(binding,delegate)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<Characters>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }
}