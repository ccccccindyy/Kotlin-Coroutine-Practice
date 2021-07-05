package com.android.example.livedatabuilder.ui.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.example.livedatabuilder.model.Cocktail
import com.android.example.livedatabuilder.model.State
import com.android.example.livedatabuilder.remote.CocktailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CocktailListViewModel @Inject constructor(val cocktailRepository: CocktailRepository): ViewModel(){
    private val _cocktailListData = MutableLiveData<State<List<Cocktail>>>()

     val cockails: LiveData<State<List<Cocktail>>> = _cocktailListData
     @ExperimentalCoroutinesApi
     internal fun getCocktails(){
        viewModelScope.launch {
            cocktailRepository.fetchCocktails()
                .onStart { _cocktailListData.value = State.loading() }
                .map{ resource -> State.fromResource(resource) }
                .collect { state -> _cocktailListData.value = state }

        }
    }
}