package com.moviles.practicanotificaciones.models

class Usuario(
    var idUsuario: Int = 0,
    var notification_id: String = ""
) {

    override fun toString(): String {
        return "Usuario(idUsuario=$idUsuario, notification_id='$notification_id')"
    }
}