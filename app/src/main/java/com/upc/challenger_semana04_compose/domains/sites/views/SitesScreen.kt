package com.upc.challenger_semana04_compose.domains.sites.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.upc.challenger_semana04_compose.domains.sites.models.dao.Site
import com.upc.challenger_semana04_compose.domains.sites.views.states.SiteViewModel
import com.upc.challenger_semana04_compose.navigation.AppScreens


@Composable
fun SitesScreen(viewModel: SiteViewModel, navController: NavController) {
    val sites = viewModel.sites

    if (sites.isEmpty()) {
        viewModel.fetchSites()
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 98.dp, bottom = 56.dp)  // Agrega espacio para la TopAppBar y TabRow
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(sites) { site ->
            SiteCard(site = site) {
                viewModel.selectSite(site)
                navController.navigate(AppScreens.SiteDetailScreen.route)
            }
        }
    }
}

@Composable
fun SiteCard(site: Site, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = site.imagen,
                contentDescription = site.nombre,
                modifier = Modifier
                    .size(100.dp)
                    .padding(end = 16.dp),
                contentScale = ContentScale.Crop
            )

            Column {
                Text(text = site.idSitio, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(text = site.nombre, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}