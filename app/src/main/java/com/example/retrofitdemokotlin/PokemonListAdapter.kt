package com.example.retrofitdemokotlin

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item_pokemon.view.*

class PokemonListAdapter (private var pokeList: List<Pokemon>) : RecyclerView.Adapter<PokemonListAdapter.PokemonListViewHolder>() {

    private  val TAG = "PokemonListAdapter"
    class PokemonListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val ivPokemonImg : ImageView = itemView.ivPokemonImg
        val ivPokemonName : TextView = itemView.tvPokemonName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListViewHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_pokemon,parent,false)
        return PokemonListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PokemonListViewHolder, position: Int) {
        val currentItem =pokeList[position]

        Log.d(TAG, "onBindViewHolder: "+(currentItem.img))

       // Picasso.get().load(currentItem.img).into(holder.ivPokemonImg)

        holder.ivPokemonName.text=currentItem.name


    }

    override fun getItemCount(): Int {
      return pokeList.size
    }
}