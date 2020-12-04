package com.example.retrofitdemokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private val BASE_URL = "https://raw.githubusercontent.com/Biuni/PokemonGO-Pokedex/master/"
    lateinit var pokeList : PokemonList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit =
            Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL)
                .build()

        val retrofitApi = retrofit.create(RetrofitApi::class.java)
        val call : Call<PokemonList> = retrofitApi.getPokemonListCall()

        call.enqueue(object : Callback<PokemonList> {
            override fun onResponse(
                call: Call<PokemonList>,
                response: Response<PokemonList>
            ) {
                pokeList=response.body()!!
                var list = pokeList.pokemon

                rvPokemonList.adapter=PokemonListAdapter(list)
                rvPokemonList.layoutManager=LinearLayoutManager(this@MainActivity)
                rvPokemonList.setHasFixedSize(true)
            }

            override fun onFailure(call: Call<PokemonList>, t: Throwable) {
                Log.d(TAG, "onFailure: "+t.message)
            }

        })
    }
}