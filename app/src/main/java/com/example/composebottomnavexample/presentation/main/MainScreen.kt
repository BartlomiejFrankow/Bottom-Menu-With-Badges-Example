package com.example.composebottomnavexample.presentation.main

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.composebottomnavexample.presentation.navigation.BottomNavigationMenu
import com.example.composebottomnavexample.presentation.navigation.Navigation

@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(bottomBar = {
        BottomNavigationMenu(
            navState = navController.currentBackStackEntryAsState()
        ) { navController.navigate(it.route) }
    }) {
        Navigation(navHostController = navController)
    }
}
