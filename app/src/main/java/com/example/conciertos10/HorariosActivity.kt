package com.example.conciertos10

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HorariosActivity : AppCompatActivity() {

    private lateinit var edtNombre: EditText
    private lateinit var edtApellido: EditText
    private lateinit var edtCorreo: EditText
    private lateinit var spinnerHorarios: Spinner
    private lateinit var btnGuardar: Button
    private lateinit var btnMostrar: Button
    private lateinit var txtDetalles: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horarios)

        edtNombre = findViewById(R.id.edtNombre)
        edtApellido = findViewById(R.id.edtApellidos)
        edtCorreo = findViewById(R.id.edtEmail)
        spinnerHorarios = findViewById(R.id.spinnerHorarios)
        btnGuardar = findViewById(R.id.btnGuardar)
        btnMostrar = findViewById(R.id.btnDetalles)
        txtDetalles = findViewById(R.id.txtDetalles)

        // Referencias a los elementos del layout
        val imageViewConcierto = findViewById<ImageView>(R.id.imageViewConcierto)
        val spinnerHorarios = findViewById<Spinner>(R.id.spinnerHorarios)
        val edtNombre = findViewById<EditText>(R.id.edtNombre)
        val edtApellido = findViewById<EditText>(R.id.edtApellidos)
        val edtCorreo = findViewById<EditText>(R.id.edtEmail)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)
        val btnDetalles = findViewById<Button>(R.id.btnDetalles)
        val btnLimpiar = findViewById<Button>(R.id.btnLimpiar)
        val txtDetalles = findViewById<TextView>(R.id.txtDetalles)

        // Obtener el concierto seleccionado desde la primera actividad
        val conciertoSeleccionado = intent.getIntExtra("conciertoSeleccionado", R.drawable.ic_launcher_foreground)
        imageViewConcierto.setImageResource(conciertoSeleccionado)

        // Lista de horarios para el concierto seleccionado
        val horarios = arrayOf("10:00 AM", "2:00 PM", "6:00 PM", "9:00 PM")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, horarios)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerHorarios.adapter = adapter

        btnGuardar.setOnClickListener {
            guardarDatos()
        }

        btnDetalles.setOnClickListener {
            mostrarDatos()
        }

        btnLimpiar.setOnClickListener{
            limpiarCampos()
        }
    }

    private fun guardarDatos() {
        val nombre = edtNombre.text.toString().trim()
        val apellido = edtApellido.text.toString().trim()
        val correo = edtCorreo.text.toString().trim()
        val horarioSeleccionado = spinnerHorarios.selectedItem.toString()

        // Validación de campos
        if (nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty()) {
            Toast.makeText(this, "Por favor, completa todos los campos.", Toast.LENGTH_SHORT).show()
            return
        }

        // Se muestra un mensaje de éxito
        Toast.makeText(this, "Datos guardados correctamente.", Toast.LENGTH_SHORT).show()

        // Limpiar campos
        limpiarCampos()
    }

    private fun limpiarCampos() {
        edtNombre.text.clear()
        edtApellido.text.clear()
        edtCorreo.text.clear()
        spinnerHorarios.setSelection(0) // Resetear al primer item del spinner
    }

    private fun mostrarDatos() {
        val nombre = edtNombre.text.toString()
        val apellido = edtApellido.text.toString()
        val correo = edtCorreo.text.toString()
        val horarioSeleccionado = spinnerHorarios.selectedItem.toString()

        txtDetalles.text = "Nombre: $nombre\nApellido: $apellido\nCorreo: $correo\nHorario: $horarioSeleccionado"
    }
}