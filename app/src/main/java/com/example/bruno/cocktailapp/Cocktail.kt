package com.example.bruno.cocktailapp

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

@Entity
data class Cocktail (var idDrink: String,
                     var strDrink: String,
                     var strCategory: String,
                     var strGlass: String,
                     var strDrinkThumb: String,
                     var strInstructions: String,
                     var strIngredient1: String,
                     var strIngredient2: String,
                     var strIngredient3: String,
                     var strIngredient4: String,
                     var strIngredient5: String,
                     @PrimaryKey(autoGenerate = true)
                     var id: Int = 0) : Serializable
