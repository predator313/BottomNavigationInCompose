package com.aamirashraf.bottomnavigationincompose.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.BadgedBox
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
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
        composable("settings"){
            SettingScreen()
        }
    }
}
//bottom navigation is working fine and it is just amazing way to do the ui of it
//it is one of the best thing in compose to use the navigation
//all bottom navigation related work is done
@Composable
fun BottomNavigationBar(
    item:List<NavigationItem>,
    navController: NavController,
    modifier: Modifier=Modifier,
    onItemClick:(NavigationItem)->Unit
){
    //now lets get the current navigation back stack as state
    val backStackEntry=navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier=modifier,
        backgroundColor = Color.DarkGray,
        elevation = 5.dp
    ) {
        item.forEach { item->
            val selected=item.route==backStackEntry.value?.destination?.route
            BottomNavigationItem(selected =selected , onClick = {
                onItemClick(item)
            },
                selectedContentColor = Color.Green,
                unselectedContentColor = Color.Gray,
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        if(item.badgeCount>0){
                            BadgedBox(
                                badge = {
                                        Text(text = item.badgeCount.toString())
                                }
                               
                            ) {
                                Icon(imageVector = item.icon, contentDescription =item.name)
                            }
                        }
                        else{
                            Icon(imageVector = item.icon, contentDescription =item.name)
                        }
                        if(selected){
                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp

                            )
                        }
                    }
                })
        }
    }

}