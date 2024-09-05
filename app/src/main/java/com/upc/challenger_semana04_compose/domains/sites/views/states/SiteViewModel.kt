package com.upc.challenger_semana04_compose.domains.sites.views.states

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.upc.challenger_semana04_compose.domains.sites.models.dao.Site
import com.upc.challenger_semana04_compose.utils.RetrofitClient
import kotlinx.coroutines.launch
import retrofit2.Response

class SiteViewModel:ViewModel() {
    var sites by mutableStateOf<List<Site>>(emptyList())
        private set

    var selectedSiteState by mutableStateOf(SiteState())
        private set

    fun fetchSites() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.placeHolder.getSitios()
                if (response.isSuccessful) {
                    response.body()?.let {
                        sites = it
                    }
                }
            } catch (e: Exception) {
                // Manejar error
            }
        }
    }

    fun selectSite(site: Site) {
        selectedSiteState = SiteState(
            idSitio = site.idSitio,
            nombre = site.nombre,
            desripcion = site.descripcion,
            pais = site.pais,
            imagen = site.imagen
        )
    }

}