package com.example.retrofitdemokotlin

import com.google.gson.annotations.SerializedName

data class PokemonList (@SerializedName("pokemon")  val pokemon :List<Pokemon>,
)

data class Pokemon ( val id :String,
                        val name:String,
                         val img:String,
                       // private val type:String
)
