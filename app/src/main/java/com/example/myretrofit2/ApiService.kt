package com.example.ploichao.network
import com.example.myretrofit2.Album
import com.example.myretrofit2.UserInfo
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


val BASE_URL= "https://jsonplaceholder.typicode.com/"

interface ApiService {

    @GET("albums")
    fun  getAlbums(): Call<List<Album>>

    @GET("albums/{no}")
    fun getQueryString (@Path("no") no: Int):Call<Album>

    // Mockup api interface class
    @Headers("Content-Type: application/json")
    @POST("users")
    fun addUser(@Body userData: UserInfo): Call<UserInfo>


    companion object{
        operator fun invoke():ApiService{
            return  Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }

    }

    /* Readme
     [] Retrofit -> https://square.github.io/retrofit/
     [] Ex. -> https://jsonplaceholder.typicode.com/albums/1
     [] Ex JSONPlaceholder -> http://jsonplaceholder.typicode.com/
     [] Retrofit method post -> https://www.youtube.com/watch?v=GP5OyYDu_mU
     [] Retrofit post ->https://medium.com/swlh/simplest-post-request-on-android-kotlin-using-retrofit-e0a9db81f11a
    */

}