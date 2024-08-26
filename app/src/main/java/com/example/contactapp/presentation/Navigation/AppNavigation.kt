package com.example.contactapp.presentation.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.contactapp.data.dao.ContactDao
import com.example.contactapp.presentation.Screen.AddEditContactScreen
import com.example.contactapp.presentation.Screen.Mainscreen


@Composable
fun AppNavigation(dbObject: ContactDao) {
    val navController=rememberNavController()
    NavHost(navController=navController,startDestination = ContactScreen)
    {

        composable<ContactScreen> {
            Mainscreen(dbObject,navController)
        }

        composable<SaveEditScreen> {
           AddEditContactScreen(dbObject,navController)

        }

    }
}