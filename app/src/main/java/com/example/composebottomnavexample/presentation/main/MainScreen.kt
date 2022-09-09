package com.example.composebottomnavexample.presentation.main

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.composebottomnavexample.presentation.navigation.BottomNavigationMenu
import com.example.composebottomnavexample.presentation.navigation.Navigation

@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(bottomBar = {
        BottomNavigationMenu(
            navController = navController,
            onItemClick = { navController.navigate(it.route) }
        )
    }) {
        Navigation(navHostController = navController)
    }
}
