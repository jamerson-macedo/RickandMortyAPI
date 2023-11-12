package com.example.rickandmortyapi.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun RickAndMortyNavGraph(
    modifier: Modifier = Modifier,
    navgateToHome: () -> Unit,
    navgateToDetail: (Int) -> Unit,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.Home.route
) {
    NavHost(navController = navController, startDestination = startDestination, modifier) {

        composable(route = Screen.Home.route) {
            HomeScreen(onItemClicked = { navgateToDetail(it) }
            )
        }
    }
}