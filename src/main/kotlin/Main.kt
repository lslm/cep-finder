import com.google.gson.Gson
import models.CepInfoResponse
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.util.Scanner

fun main(args: Array<String>) {
    println("CEP Finder")

    val scanner = Scanner(System.`in`)
    print("Digite um CEP para pesquisa: ")
    val cep = scanner.nextLine()

    val address = "https://brasilapi.com.br/api/cep/v2/$cep"

    val client = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(address))
        .build()

    val response = client.send(request, HttpResponse.BodyHandlers.ofString())
    val jsonResponse = response.body()

    val gson = Gson()

    val cepInfoResponse = gson.fromJson(jsonResponse, CepInfoResponse::class.java)

    println("Informações encontradas:")
    println("Cidade: ${cepInfoResponse.city}\nEstado: ${cepInfoResponse.state}\nRua: ${cepInfoResponse.street}")
    println("Longitude: ${cepInfoResponse.location.coordinates.longitude}")
    println("Latitude: ${cepInfoResponse.location.coordinates.latitude}")
}
