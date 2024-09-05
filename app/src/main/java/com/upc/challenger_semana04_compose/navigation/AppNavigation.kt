package com.upc.challenger_semana04_compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.upc.challenger_semana04_compose.domains.sites.views.AppScaffold
import com.upc.challenger_semana04_compose.domains.sites.views.SiteDetailScreen
import com.upc.challenger_semana04_compose.domains.sites.views.SitesScreen
import com.upc.challenger_semana04_compose.domains.sites.views.states.SiteViewModel

@Composable
fun AppNavigation(viewSiteModel: SiteViewModel){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.SitesScreen.route) {
        composable(AppScreens.SitesScreen.route) {
            AppScaffold(navController = navController) {
                SitesScreen(viewSiteModel, navController)
            }
        }
        composable(AppScreens.SiteDetailScreen.route) {
            AppScaffold(navController = navController) {
                SiteDetailScreen(viewModel = viewSiteModel)
            }
        }
    }
}