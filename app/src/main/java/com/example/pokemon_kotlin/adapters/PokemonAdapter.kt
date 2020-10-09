package com.example.pokemon_kotlin.adapters

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import com.example.pokemon_kotlin.R
import com.example.pokemon_kotlin.model.Pokemon


 class PokemonAdapter(mContext: Context) : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {
    private var mList: ArrayList<Pokemon> = ArrayList()
    private val mContext: Context

    init {
        this.mContext = mContext
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.pokemonName.setText(mList[position].name)
        Glide.with(mContext).load(mList[position].url)
            .into(holder.pokemonImage)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    fun setList(mList: ArrayList<Pokemon>) {
        this.mList = mList
        notifyDataSetChanged()
    }

    inner class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val pokemonImage: ImageView
         val pokemonName: TextView

        init {
            pokemonImage = itemView.findViewById(R.id.pokemon_imageView)
            pokemonName = itemView.findViewById(R.id.pokemon_name_textView)
        }
    }


}