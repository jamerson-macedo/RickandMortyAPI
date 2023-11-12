package com.example.rickandmortyapi.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.example.rickandmortyapi.ui.theme.RickAndMortyAPITheme


@Composable
fun RickAndMortyApp() {
    RickAndMortyAPITheme {
        val navController = rememberNavController()
        val navigationActions= remember(navController) {
            RickAndMortyActions(navController)
        }
        RickAndMortyNavGraph()
    }
}