package com.upc.challenger_semana04_compose.utils.interfaces

import com.upc.challenger_semana04_compose.domains.sites.models.dao.Site
import retrofit2.Response
import retrofit2.http.GET

interface PlaceHolder {
    @GET("sitios.php")
    suspend fun getSitios(): Response<List<Site>>
}