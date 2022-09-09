package com.example.composebottomnavexample.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composebottomnavexample.presentation.chat.ChatScreen
import com.example.composebottomnavexample.presentation.home.HomeScreen
import com.example.composebottomnavexample.presentation.navigation.Navigation.*
import com.example.composebottomnavexample.presentation.settings.SettingsScreen

@Composable
fun Navigation(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = HOME.value) {
        composable(HOME.value) { HomeScreen() }
        composable(CHAT.value) { ChatScreen() }
        composable(SETTINGS.value) { SettingsScreen() }
    }
}

enum class Navigation(val value: String) {
    HOME("home"),
    CHAT("chat"),
    SETTINGS("settings")
}
