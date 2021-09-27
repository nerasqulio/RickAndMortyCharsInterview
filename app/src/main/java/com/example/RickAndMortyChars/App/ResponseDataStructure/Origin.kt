package com.example.RickAndMortyChars.App.ResponseDataStructure

import java.io.Serializable

data class Origin(
    val name: String,
    val url: String
) : Serializable