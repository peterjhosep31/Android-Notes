package com.example.notas

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MensajeView : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mensaje)

        var blunde = intent.extras
        var nombre = blunde?.getString("nom")
        var nota1 = blunde?.getString("not1")
        var nota2 = blunde?.getString("not2")
        var nota3 = blunde?.getString("not3")
        var promedio = blunde?.getString("prom")
        var respuesta = blunde?.getString("resp")

        var mensaje = findViewById<TextView>(R.id.nombre)
        var mensaje2 = findViewById<TextView>(R.id.notes)
        var mensaje3 = findViewById<TextView>(R.id.result)

        mensaje.text = nombre
        mensaje2.text = "Sus notas son: $nota1, $nota2, $nota3 y su promedio es: $promedio"
        mensaje3.text = respuesta
        var color: String? = null
        if (respuesta == "Aprovo la materia, Felicidades") {
            color = "green"
            mensaje3.setTextColor(color.toInt())
        } else {
            color = "red"
            mensaje3.setTextColor(color.toInt())
        }




    }

}