package com.example.projet2

import retrofit2.Call
import retrofit2.http.GET

interface DisneyApiService  {
        @GET("character")
        fun getCharacters(): Call<DisneyResponse>
}