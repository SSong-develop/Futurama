package com.ssong_develop.presentation.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.ssong_develop.domain.entities.Characters
import com.ssong_develop.presentation.R
import com.ssong_develop.presentation.adapters.CharacterListAdapter
import com.ssong_develop.presentation.databinding.ActivityMainBinding
import com.ssong_develop.presentation.viewholders.CharacterViewHolder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), CharacterViewHolder.Delegate {

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    private var characterAdapter: CharacterListAdapter? = null

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(binding) {
            lifecycleOwner = this@MainActivity
            vm = viewModel
        }
        characterAdapter = CharacterListAdapter(this)

        binding.characterList.apply {
            adapter = characterAdapter
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.characters.collect {
                    it.data?.let { it1 -> characterAdapter!!.submitList(it1) }
                }
            }
        }
/*        lifecycleScope.launch {
            viewModel.characters
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect {
                    it.data?.let { it1 ->
                        characterAdapter!!.submitList(it1)
                    }
                }
        }*/
    }

    override fun onItemClick(view: View, character: Characters) {
        Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        characterAdapter = null
        super.onDestroy()
    }
}