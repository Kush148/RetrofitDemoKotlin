package com.example.retrofitdemokotlin

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitApi {
    @GET("pokedex.json")
    fun getPokemonListCall() : Call<PokemonList>
}