package com.example.projet2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.charactersRecyclerView)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.disneyapi.dev/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(DisneyApiService::class.java)

        service.getCharacters().enqueue(object : Callback<DisneyResponse> {
            override fun onResponse(call: Call<DisneyResponse>, response: Response<DisneyResponse>) {
                response.body()?.data?.let { characters ->
                    runOnUiThread {
                        recyclerView.adapter = DisneyCharacterAdapter(characters)
                    }
                }
            }

            override fun onFailure(call: Call<DisneyResponse>, t: Throwable) {
                Log.d("sacha","error happened")
            }
        })
    }
}
