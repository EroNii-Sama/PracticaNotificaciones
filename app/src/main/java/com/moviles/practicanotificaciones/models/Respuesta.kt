package com.moviles.practicanotificaciones.models

class Respuesta(
    var res: String = "",
    var charla: ArrayList<Charla> = ArrayList(),
) {
    class Charla(
        var id: Int = 0,
        var idUsuarioEnvio: Int = 0,
        var idUsuarioRecepcion: Int = 0,
        var nombreEnvio: String = "",
        var nombreReceptor: String = "",
        var ultimoMensaje: String = ""
    ) {
        override fun toString(): String {
            return "Charla(id=$id, idUsuarioEnvio=$idUsuarioEnvio, idUsuarioRecepcion=$idUsuarioRecepcion, nombreEnvio='$nombreEnvio', nombreReceptor='$nombreReceptor', ultimoMensaje='$ultimoMensaje')"
        }
    }
}