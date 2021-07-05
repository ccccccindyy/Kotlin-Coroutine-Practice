package com.android.example.livedatabuilder.ui.ui.main

import android.R.attr.data
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.example.livedata.R
import com.android.example.livedata.databinding.ActivityLivedataBinding
import com.android.example.livedata.databinding.CocktailsFragmentBinding
import com.android.example.livedatabuilder.model.State
import com.android.example.livedatabuilder.ui.BlankViewModel
import com.android.example.livedatabuilder.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@AndroidEntryPoint
class CocktailListFragment : Fragment() {

    companion object {
        fun newInstance() = CocktailListFragment()
    }

    private val viewModel: CocktailListViewModel by viewModels()

    private val adapter = CocktailListAdapter();

    @ExperimentalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = CocktailsFragmentBinding.inflate(
                inflater, container, false)
        binding.run {
            cocktailRecyclerView.adapter = adapter
            swipeRefreshLayout.setOnRefreshListener { viewModel.getCocktails() }
        }


        return binding.root
    }

    override fun onStart() {
        super.onStart()
        observePosts()
    }

    private fun observePosts() {
        viewModel.cockails.observe(this) { state ->
            when (state) {
                is State.Success -> {
                    if (state.data.isNotEmpty()) {
                        adapter.submitList(state.data.toMutableList())
                    }
                }
                is State.Error -> {
                     Toast.makeText(activity, "Something Wrong", Toast.LENGTH_LONG).show()
                }
            }
        }
    }




}