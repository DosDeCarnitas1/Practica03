package com.example.conciertos10

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val listViewConciertos = findViewById<ListView>(R.id.lstConciertos)

        // Lista de conciertos con imágenes (IDs de los drawables)
        val conciertos = listOf(
            Pair(R.drawable.concierto1, "Concierto de Travis Scott"),
            Pair(R.drawable.concierto2, "Concierto de Taylor Swift"),
            Pair(R.drawable.concierto3, "Concierto de Post Malone"),
            Pair(R.drawable.concierto4, "Concierto de Martin Garrix"),
            Pair(R.drawable.concierto5, "Concierto de Dua Lipa"),
            Pair(R.drawable.concierto6, "Concierto de BadBunny"),
            Pair(R.drawable.concierto7, "Concierto de Gera MX"),
            Pair(R.drawable.concierto8, "Concierto de Duki")
        )

        // Configura el adaptador personalizado
        val adapter = ConciertoAdapter(this, conciertos)
        listViewConciertos.adapter = adapter

        listViewConciertos.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, HorariosActivity::class.java)
            intent.putExtra("conciertoSeleccionado", conciertos[position].first)
            startActivity(intent)
        }
    }
}