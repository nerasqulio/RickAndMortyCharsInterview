package com.example.RickAndMortyChars.App.ResponseDataStructure

import java.io.Serializable

data class Location(
    val name: String,
    val url: String
) : Serializable