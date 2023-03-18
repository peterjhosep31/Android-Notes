package com.example.notas

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var respuesta: String? = null

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var nombre = findViewById<EditText>(R.id.nombre)
        var nota1 = findViewById<EditText>(R.id.notes)
        var nota2 = findViewById<EditText>(R.id.notes2)
        var nota3 = findViewById<EditText>(R.id.notes3)

        var boton = findViewById<Button>(R.id.button)

        var datos = mutableMapOf<String, String>()
            datos.put("nom", nombre.text.toString())
            datos.put("not1", nota1.text.toString())
            datos.put("not2", nota2.text.toString())
            datos.put("not3", nota3.text.toString())

        boton.setOnClickListener{
            sendData(datos)
        }

    }

    private fun sendData(datos: MutableMap<String, String>) {
        var promedio = (datos["not1"]!!.toInt() + datos["not2"]!!.toInt() + datos["not3"]!!.toInt()) / 3
        if (promedio >= 3) {
            respuesta = "Aprovo la materia, Felicidades"
        } else {
            respuesta = "Reprobaste la materia, suerte para la proxima"
        }

        val intent = Intent(this, MensajeView::class.java)
        var blunde = Bundle()
            blunde.putString("nom", datos["nom"])
            blunde.putString("not1", datos["not1"])
            blunde.putString("not2", datos["not2"])
            blunde.putString("not3", datos["not3"])
            blunde.putString("prom", promedio.toString())
            blunde.putString("resp", respuesta)

        intent.putExtras(blunde)
        startActivity(intent)
    }

}