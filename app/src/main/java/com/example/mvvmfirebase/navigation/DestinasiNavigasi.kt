package com.example.mvvmfirebase.navigation

interface DestinasiNavigasi {
    val route: String
    val titleRes: String
}

object DestinasiHome : DestinasiNavigasi {
    override val route : String = "home"
    override val titleRes : String = "Home"
}

object DestinasiEntry : DestinasiNavigasi {
    override val route : String = "insert"
    override val titleRes : String = "Insert"
}

object DestinasiDetail : DestinasiNavigasi {
    override val route = "detail"
    override val titleRes = "Detail"
    const val NIM = "nim"
    val routeWithArgs = "$route/{$NIM}"
}