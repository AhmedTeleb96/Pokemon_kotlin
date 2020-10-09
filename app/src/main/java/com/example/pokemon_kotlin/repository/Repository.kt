package com.example.pokemon_kotlin.repository

import androidx.lifecycle.LiveData
import com.example.pokemon_kotlin.model.PokemonResponse

import com.example.pokemon_kotlin.network.PokemonApiService
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

import javax.inject.Inject


class Repository @Inject constructor(private val pokemonApiService: PokemonApiService) {

    suspend fun getPokemons() : PokemonResponse
        = pokemonApiService.getPokemons()

}