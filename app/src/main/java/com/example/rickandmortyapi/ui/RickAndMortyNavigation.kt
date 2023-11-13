package com.example.rickandmortyapi.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination

sealed class Screen(val route: String) {
    // definindo nossa rota
    object Home: Screen("home")
    object Detail: Screen("detail?id={id}") {
        fun passId(id: Int): String {
            return "detail?id=$id"
        }
    }
}
// configurando nossas rotas
class RickAndMortyActions(navController: NavController) {
    val navigateToHome: () -> Unit = {
        navController.navigate(Screen.Home.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
// passando o id do item clicado
    val navigateToDetail = { id: Int ->
        navController.navigate(Screen.Detail.passId(id)) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
        }
    }
}