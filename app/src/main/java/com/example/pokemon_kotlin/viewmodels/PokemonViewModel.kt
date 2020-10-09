package com.example.pokemon_kotlin.viewmodels

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.pokemon_kotlin.model.Pokemon
import com.example.pokemon_kotlin.model.PokemonResponse
import com.example.pokemon_kotlin.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*


class PokemonViewModel @ViewModelInject constructor(val repository: Repository) : ViewModel() {

    lateinit var  pokemonList : Flow<ArrayList<Pokemon>>

    suspend fun getPokemonList(): Flow<ArrayList<Pokemon>> {
        return pokemonList
    }

   suspend fun getPokemons()  {

       pokemonList = flow<PokemonResponse>
       {
           emit( repository.getPokemons() )
       }
            .flowOn(Dispatchers.IO)
            .map { pokemonResponse ->

                val list = pokemonResponse.results
                list.forEach {pokemon ->
                    val url = pokemon.url
                    val pokemonIndex = url.split("/")
                    pokemon.url = "https://pokeres.bastionbot.org/images/pokemon/" + pokemonIndex[pokemonIndex.size - 2] + ".png"
                }
                list
            }
            .catch { error-> Log.e("viwModel", error.message) }
            .conflate()

   }
}