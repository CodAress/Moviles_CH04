package com.upc.challenger_semana04_compose.domains.sites.views

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.upc.challenger_semana04_compose.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppScaffold(navController: NavController, content: @Composable () -> Unit) {
    val currentDestination = navController.currentBackStackEntry?.destination

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Sitios Turísticos", color = Color.White) },
                navigationIcon = {
                    if (currentDestination?.route != AppScreens.SitesScreen.route) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White,
                            modifier = Modifier.clickable {
                                navController.popBackStack()
                            }
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        bottomBar = {
            TabRow(
                selectedTabIndex = 0,  // Índice del tab seleccionado
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White
            ) {
                Tab(
                    selected = currentDestination?.route == AppScreens.SitesScreen.route,  // Seleccionado si es SitesScreen
                    onClick = { navController.navigate(AppScreens.SitesScreen.route) },
                    icon = { Icon(Icons.Filled.Home, contentDescription = "Home") }
                )
            }
        },
        content = { content() }  // Pasa el contenido a Scaffold
    )
}