package com.example.pokemon_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import com.example.pokemon_kotlin.adapters.PokemonAdapter
import com.example.pokemon_kotlin.model.Pokemon
import com.example.pokemon_kotlin.viewmodels.PokemonViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?)   {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel : PokemonViewModel by viewModels()

        val adapter: PokemonAdapter = PokemonAdapter(this)
        pokemon_recyclerView.setAdapter(adapter);


        // Coroutine to get pokemons using Flow
       lifecycleScope.launchWhenStarted {

           viewModel.getPokemons();

           viewModel.getPokemonList().collect { pokemons ->
               adapter.setList(pokemons);
           }
       }


    }
}