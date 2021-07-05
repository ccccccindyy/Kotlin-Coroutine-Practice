package com.android.example.livedatabuilder.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.example.livedatabuilder.model.Cocktail.Companion.TABLE_NAME
import com.squareup.moshi.Json

class Drinks {
     lateinit var  drinks: List<Cocktail>
}