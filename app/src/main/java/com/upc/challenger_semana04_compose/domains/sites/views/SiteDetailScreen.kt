package com.upc.challenger_semana04_compose.domains.sites.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.upc.challenger_semana04_compose.domains.sites.views.states.SiteViewModel

@Composable
fun SiteDetailScreen(viewModel: SiteViewModel) {
    val siteState = viewModel.selectedSiteState

    Column(
        modifier = Modifier.fillMaxSize().padding(top = 98.dp).padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(
            painter = rememberImagePainter(siteState.imagen),
            contentDescription = siteState.nombre,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.Crop
        )

        Text(text = "ID: ${siteState.idSitio}", fontSize = 18.sp)
        Text(text = "Nombre: ${siteState.nombre}", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(text = "Descripción: ${siteState.desripcion}", fontSize = 16.sp)
        Text(text = "País: ${siteState.pais}", fontSize = 16.sp)
    }
}