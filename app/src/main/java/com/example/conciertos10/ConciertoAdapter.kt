package com.example.conciertos10

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageButton
import android.widget.TextView

class ConciertoAdapter(private val context: Context, private val conciertos: List<Pair<Int, String>>) : BaseAdapter() {

    override fun getCount(): Int {
        return conciertos.size
    }

    override fun getItem(position: Int): Any {
        return conciertos[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_concierto, parent, false)

        // Obtén el ImageButton y el TextView del layout
        val btnConcierto = view.findViewById<ImageButton>(R.id.btnConcierto)
        val txtArtista = view.findViewById<TextView>(R.id.txtArtista)

        // Configura la imagen del botón y el texto del artista
        val (imageResId, artista) = conciertos[position]
        btnConcierto.setImageResource(imageResId)
        txtArtista.text = artista

        return view
    }
}