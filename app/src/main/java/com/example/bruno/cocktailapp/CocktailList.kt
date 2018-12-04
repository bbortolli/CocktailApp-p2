package com.example.bruno.cocktailapp
import com.google.gson.annotations.SerializedName

data class CocktailList (@SerializedName("drinks") val cocktails: List<Cocktail>)
