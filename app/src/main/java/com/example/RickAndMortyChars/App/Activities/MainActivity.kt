package com.example.RickAndMortyChars.App.Activities

import com.example.RickAndMortyChars.App.Networking.Model
import com.example.RickAndMortyChars.App.ResponseDataStructure.GetCharIDResponse
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmortychars.R

import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {


    val viewModel : Model by lazy{
        ViewModelProvider(this).get(Model::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {

        val response : GetCharIDResponse = intent.getSerializableExtra("object") as GetCharIDResponse
        val message : String = intent.getStringExtra("ID")!!
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val nameVal = findViewById<AppCompatTextView>(R.id.nameVal)
        val statusVal = findViewById<AppCompatTextView>(R.id.statusVal)
        val locationVal = findViewById<AppCompatTextView>(R.id.locationVal)
        val charImage = findViewById<AppCompatImageView>(R.id.charImage)


        nameVal.text = response.name
        statusVal.text = response.status
        locationVal.text = response.location.name
        Picasso.get().load(response.image).into(charImage);

        val button = findViewById<AppCompatButton>(R.id.button)

        button.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }


    }
}