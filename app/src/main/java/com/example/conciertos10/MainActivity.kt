package com.example.conciertos10

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var conciertos: List<Temp>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val listViewConciertos = findViewById<ListView>(R.id.lstConciertos)

        // Lista de conciertos con imágenes (IDs de los drawables)
        conciertos = listOf<Temp>(
            Temp(R.drawable.concierto1, "Concierto de Travis Scott") { i -> onConciertoClick(i)} ,
            Temp(R.drawable.concierto2, "Concierto de Taylor Swift") { i -> onConciertoClick(i)},
            Temp(R.drawable.concierto3, "Concierto de Post Malone") { i -> onConciertoClick(i)},
            Temp(R.drawable.concierto4, "Concierto de Martin Garrix") { i -> onConciertoClick(i)},
            Temp(R.drawable.concierto5, "Concierto de Dua Lipa") { i -> onConciertoClick(i)},
            Temp(R.drawable.concierto6, "Concierto de BadBunny") { i -> onConciertoClick(i)},
            Temp(R.drawable.concierto7, "Concierto de Gera MX") { i -> onConciertoClick(i)},
            Temp(R.drawable.concierto8, "Concierto de Duki") { i -> onConciertoClick(i)}
        )

        // Configura el adaptador personalizado
        val adapter = ConciertoAdapter(this, conciertos)
        listViewConciertos.adapter = adapter

        listViewConciertos.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->

        }
    }

    fun onConciertoClick(index: Int) {
        val intent = Intent(this, HorariosActivity::class.java)
        intent.putExtra("conciertoSeleccionado", conciertos[index].image)
        startActivity(intent)
    }


}