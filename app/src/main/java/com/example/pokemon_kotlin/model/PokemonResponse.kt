package com.example.pokemon_kotlin.model

data class PokemonResponse(val count:Int , val next:String , val prev:String , val results: ArrayList<Pokemon>)