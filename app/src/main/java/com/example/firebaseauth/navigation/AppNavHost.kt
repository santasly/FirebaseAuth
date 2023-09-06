package com.example.firebaseauth.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firebaseauth.ui.theme.screens.login.LoginScreen
import com.example.firebaseauth.ui.theme.screens.register.RegisterScreen

@androidx.compose.runtime.Composable
fun AppNavHost(modifier:Modifier=Modifier, navController: NavHostController= rememberNavController(),
               startDestination: String= ROUTE_LOGIN) {
    NavHost(navController=navController, modifier = Modifier, startDestination =startDestination){
        composable(ROUTE_LOGIN){
            LoginScreen(navController)
        }
        composable(ROUTE_REGISTER){
            RegisterScreen(navController)
        }
    }


}