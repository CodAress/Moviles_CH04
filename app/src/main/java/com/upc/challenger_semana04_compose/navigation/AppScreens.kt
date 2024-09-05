package com.upc.challenger_semana04_compose.navigation

sealed class AppScreens (val route: String) {
    data object SitesScreen: AppScreens("sites_screen")
    data object SiteDetailScreen : AppScreens ("site_detail_screen")
}