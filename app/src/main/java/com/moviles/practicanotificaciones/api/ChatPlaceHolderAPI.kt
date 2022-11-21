package com.moviles.practicanotificaciones.api

import com.moviles.practicanotificaciones.models.Conversacion
import com.moviles.practicanotificaciones.models.Respuesta
import com.moviles.practicanotificaciones.models.Usuario
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ChatPlaceHolderAPI {
    @POST("iniciarsesion")
    fun iniciarSesion(@Body usuario: Usuario): Call<Respuesta>

    @POST("addcharla")
    fun addCharla(@Body conversacion: Conversacion): Call<Respuesta>
}