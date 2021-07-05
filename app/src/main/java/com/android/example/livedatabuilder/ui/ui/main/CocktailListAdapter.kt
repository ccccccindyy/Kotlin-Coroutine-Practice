package com.android.example.livedatabuilder.ui.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.android.example.livedata.databinding.ItemCocktailBinding
import com.android.example.livedatabuilder.model.Cocktail

class CocktailListAdapter: ListAdapter<Cocktail, CocktailViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CocktailViewHolder(
        ItemCocktailBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: CocktailViewHolder, position: Int) =
        holder.bind(getItem(position))

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Cocktail>() {
            override fun areItemsTheSame(oldItem: Cocktail, newItem: Cocktail): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Cocktail, newItem: Cocktail): Boolean =
                oldItem.id == newItem.id
        }
    }
}