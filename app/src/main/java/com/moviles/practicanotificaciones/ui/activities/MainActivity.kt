package com.moviles.practicanotificaciones.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import com.moviles.practicanotificaciones.R
import com.moviles.practicanotificaciones.models.Respuesta
import com.moviles.practicanotificaciones.models.Usuario
import com.moviles.practicanotificaciones.repositories.ChatRepository

class MainActivity : AppCompatActivity(), ChatRepository.ListenerSesion {
    val idUsuario = 28
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupFireBase()
    }

    private fun setupFireBase() {
        // el token es un identificador unico para cada dispositivo que se registra en la app
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w("TOKEN", "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }

            // Get new FCM registration token
            val token = task.result as String
            val usuario = Usuario(idUsuario, token)
            ChatRepository.iniciarSesion(usuario, this)
            // Log and toast
            Log.d("TOKEN", token)
            Toast.makeText(baseContext, token, Toast.LENGTH_SHORT).show()
        })
    }

    override fun onUsuarioSuccess(respuesta: Respuesta?) {
        val intent = Intent(this, ConversacionActivity::class.java)
        intent.putExtra("idUsuario", idUsuario)
        Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show()
        startActivity(intent)
    }

    override fun onUsuarioFailure(t: Throwable) {
        Toast.makeText(this, "Error al iniciar sesion", Toast.LENGTH_SHORT).show()
    }
}