package com.upc.challenger_semana04_compose.domains.sites.models.dao

data class Site (
    val idSitio: String,
    val nombre: String,
    val descripcion: String,
    val pais: String,
    val imagen: String
)

/*
        "idSitio": "S001",
        "nombre": "Machu Picchu",
        "descripcion": "Tierra de los Incas",
        "pais": "Peru",
        "imagen": "https://dev.formandocodigo.com/imgTurismo/machupicchu.jpg"
* */