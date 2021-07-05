package com.android.example.livedatabuilder.ui.ui.main

import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import com.android.example.livedata.databinding.ItemCocktailBinding
import com.android.example.livedatabuilder.model.Cocktail

class CocktailViewHolder(private val binding: ItemCocktailBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind(cocktail: Cocktail) {
        binding.image.setImageURI(Uri.parse(cocktail.image))
        binding.name.text = cocktail.name
        binding.category.text = cocktail.category
        binding.instruction.text = cocktail.strInstructions;
    }
}