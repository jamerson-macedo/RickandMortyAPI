package com.example.rickandmortyapi.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.example.rickandmortyapi.ui.theme.RickAndMortyAPITheme


@Composable
fun RickAndMortyApp() {
    RickAndMortyAPITheme {
        // configuramos o controler
        val navController = rememberNavController()
        val navigationActions= remember(navController) {
            // nossas acoes com o navigation
            RickAndMortyActions(navController)
        }
        RickAndMortyNavGraph(
            navController = navController,
            navigateToHome = navigationActions.navigateToHome,
            navigateToDetail = navigationActions.navigateToDetail
        )
    }
}