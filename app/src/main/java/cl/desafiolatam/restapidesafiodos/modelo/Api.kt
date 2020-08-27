package cl.desafiolatam.restapidesafiodos.modelo

import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("/photos")
    fun getLista(): Call<List<PhotoPojo>>
}