package mx.edu.uthermosillo.manuel.boletotren

data class Boleto(

    val id: Int,
    val name: String,
    val Estado: String,
    val salida: String,
    val dinero: String,
    val time: String,
    val flag: String,
    val image: String
)
