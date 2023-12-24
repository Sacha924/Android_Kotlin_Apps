package com.example.projet2;

data class DisneyCharacter(
    val _id: String,
    val name: String,
    val imageUrl: String
)

data class DisneyResponse(
    val data: List<DisneyCharacter>
)