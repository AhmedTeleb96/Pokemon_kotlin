package com.example.pokemon_kotlin.network

import androidx.lifecycle.LiveData
import com.example.pokemon_kotlin.model.PokemonResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET;


interface PokemonApiService {
    @GET("pokemon")
    suspend fun getPokemons() : PokemonResponse
}