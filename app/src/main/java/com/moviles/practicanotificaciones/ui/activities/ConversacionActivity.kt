package com.moviles.practicanotificaciones.ui.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.moviles.practicanotificaciones.R
import com.moviles.practicanotificaciones.models.Respuesta

class ConversacionActivity : AppCompatActivity() {
    private lateinit var saveButton: Button
    private lateinit var usuarioReceptor: EditText
    private lateinit var usuarioEnvio: EditText
    private var idUsuario: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversacion)
        saveButton = findViewById(R.id.saveButton)
        usuarioReceptor = findViewById(R.id.usuarioReceptor)
        usuarioEnvio = findViewById(R.id.usuarioEnvio)
    }

    private fun setupEventListeners() {
        saveButton.setOnClickListener {
        }
    }

}