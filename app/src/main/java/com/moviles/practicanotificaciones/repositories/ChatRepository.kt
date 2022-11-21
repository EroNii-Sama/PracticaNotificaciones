package com.moviles.practicanotificaciones.repositories

import com.moviles.practicanotificaciones.api.ChatPlaceHolderAPI
import com.moviles.practicanotificaciones.models.Conversacion
import com.moviles.practicanotificaciones.models.Respuesta
import com.moviles.practicanotificaciones.models.Usuario
import retrofit2.Call
import javax.xml.transform.ErrorListener

object ChatRepository {
    fun iniciarSesion(usuario: Usuario, listener: ListenerSesion) {
        val retrofit = RetrofitRepository.getRetrofit()
        val chatPlaceHolderAPI = retrofit.create(ChatPlaceHolderAPI::class.java)
        chatPlaceHolderAPI.iniciarSesion(usuario).enqueue(object : retrofit2.Callback<Respuesta> {
            override fun onResponse(
                call: Call<Respuesta>,
                response: retrofit2.Response<Respuesta>
            ) {
                if (response.isSuccessful) {
                    listener.onUsuarioSuccess(response.body())
                }
            }

            override fun onFailure(call: Call<Respuesta>, t: Throwable) {
                listener.onUsuarioFailure(t)
            }
        })
    }

    fun addCharla(conversacion: Conversacion, listener: ListenerCharla) {
        val retrofit = RetrofitRepository.getRetrofit()
        val chatPlaceHolderAPI = retrofit.create(ChatPlaceHolderAPI::class.java)
        chatPlaceHolderAPI.addCharla(conversacion).enqueue(object : retrofit2.Callback<Respuesta> {
            override fun onResponse(
                call: Call<Respuesta>,
                response: retrofit2.Response<Respuesta>
            ) {
                if (response.isSuccessful) {
                    listener.onCharlaSuccess(response.body())
                }
            }

            override fun onFailure(call: Call<Respuesta>, t: Throwable) {
                listener.onCharlaFailure(t)
            }
        })
    }

    interface ListenerSesion {
        fun onUsuarioSuccess(respuesta: Respuesta?)
        fun onUsuarioFailure(t: Throwable)
    }

    interface ListenerCharla {
        fun onCharlaSuccess(respuesta: Respuesta?)
        fun onCharlaFailure(t: Throwable)
    }


}