package com.aamirashraf.bottomnavigationincompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aamirashraf.bottomnavigationincompose.screen.ChatScreen
import com.aamirashraf.bottomnavigationincompose.screen.HomeScreen
import com.aamirashraf.bottomnavigationincompose.screen.SettingScreen

@Composable
fun Navigation(navHostController: NavHostController){
    NavHost(navController = navHostController, startDestination = "home" ){
        composable("home"){
            HomeScreen()
        }
        composable("chat"){
            ChatScreen()
        }
        composable("setting"){
            SettingScreen()
        }
    }
}