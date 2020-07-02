package com.example.myretrofit2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ploichao.network.ApiService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit private var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        apiService = ApiService()
        apiApp()
        getApiApp(3)
        //apiPost()

    }

    private fun apiApp(){
        val call: Call<List<Album>> = apiService.getAlbums()
        call.enqueue(object: Callback<List<Album>> {
            override fun onFailure(call: Call<List<Album>>, t: Throwable) {
                Log.e("Api",t.message)
            }
            override fun onResponse(call: Call<List<Album>>, response: Response<List<Album>>) {
                if(response.isSuccessful){
                    val list= response.body()
                    Log.i("API get show list","${list!!.size}")
                    text.text = "list size:"+list?.size
                }
            }
        })
    }

    private fun getApiApp(no:Int){
        val call = apiService.getQueryString(no)

        call.enqueue(object: Callback<Album> {
            override fun onFailure(call: Call<Album>, t: Throwable) {
                Log.e("API Query String",t.message)
            }
            override fun onResponse(call: Call<Album>, response: Response<Album>) {
                if(response.isSuccessful){
                    val list= response.body()
                    text2.text = list?.title.toString()
                }
            }
        })
    }


}