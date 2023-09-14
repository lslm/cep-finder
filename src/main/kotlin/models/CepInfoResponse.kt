package models

import com.google.gson.annotations.SerializedName

data class CepInfoResponse(
    val cep: String,
    val city: String,
    val state: String,
    val street: String,
    @SerializedName("neighborhood") val bairro: String,
    val location: Location
)