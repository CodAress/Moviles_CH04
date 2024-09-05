package com.upc.challenger_semana04_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.upc.challenger_semana04_compose.domains.sites.views.states.SiteViewModel
import com.upc.challenger_semana04_compose.navigation.AppNavigation
import com.upc.challenger_semana04_compose.ui.theme.Challenger_semana04_composeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val siteViewModel = SiteViewModel()
        setContent {
            Challenger_semana04_composeTheme {
                AppNavigation(siteViewModel)
            }
        }
    }
}
