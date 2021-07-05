package com.android.example.livedatabuilder.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.example.livedatabuilder.model.Cocktail.Companion.TABLE_NAME
import com.squareup.moshi.Json

@Entity(tableName = TABLE_NAME)
class Cocktail {
    @PrimaryKey
    var id: Int? = 0
    @Json(name = "strDrink")
    var name: String? = null
    @Json(name = "strCategory")
    var category: String? = null
    @Json(name="strGlass")
    var glass: String? = null
    @Json(name="strInstructions")
    var strInstructions: String? = null
    @Json(name="strDrinkThumb")
    var image: String? = null
    companion object {
        const val TABLE_NAME = "Cocktail";
    }
}