package com.aamirashraf.bottomnavigationincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.aamirashraf.bottomnavigationincompose.navigation.BottomNavigationBar
import com.aamirashraf.bottomnavigationincompose.navigation.Navigation
import com.aamirashraf.bottomnavigationincompose.navigation.NavigationItem
import com.aamirashraf.bottomnavigationincompose.ui.theme.BottomNavigationInComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomNavigationInComposeTheme {
                // A surface container using the 'background' color from the theme
                val navController= rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(item = listOf(
                            NavigationItem(
                                name = "Home",
                                route = "home",
                                icon = Icons.Default.Home
                            ),

                            NavigationItem(
                                name = "Chat",
                                route = "chat",
                                icon = Icons.Default.Notifications,
                                badgeCount = 245
                            ),
                            NavigationItem(
                                name = "Settings",
                                route = "settings",
                                icon = Icons.Default.Settings
                            )
                        ), navController =navController , onItemClick ={
                            navController.navigate(it.route)
                        } )
                    }
                ) {
                    Navigation(navHostController = navController)
                }
            }
        }
    }
}

