package com.moviles.practicanotificaciones.models

class Conversacion(
    var idUsuarioEnvio: Int = 0,
    var idUsuarioReceptor: Int = 0
) {
    override fun toString(): String {
        return "Conversacion(idUsuarioEnvio=$idUsuarioEnvio, idUsuarioReceptor=$idUsuarioReceptor)"
    }
}