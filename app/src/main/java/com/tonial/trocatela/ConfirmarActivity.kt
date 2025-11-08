package com.tonial.trocatela

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConfirmarActivity : AppCompatActivity() {

    private lateinit var tvCod: TextView
    private lateinit var tvQtd: TextView
    private lateinit var tvValor: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirmar)

        tvCod = findViewById(R.id.tvCod)
        tvQtd = findViewById(R.id.tvQtd)
        tvValor = findViewById(R.id.tvValor)

        val cod = intent.getIntExtra("cod", 0)
        val qtd = intent.getStringExtra("qtd")
        val valor = intent.getStringExtra("valor")

        tvCod.text = cod.toString()
        tvQtd.text = qtd
        tvValor.text = valor

    }

    fun btnConfirmarSMSOnClick(view: View) {
        val sms = "Cod: ${tvCod.text} Qtd: ${tvQtd.text} Valor: ${tvValor.text}";

        val intent = Intent(Intent.ACTION_VIEW)

        intent.setData(Uri.parse("sms:+554699262206"))
        intent.putExtra("sms_body", "Olá, gostaria de confirmar o pedido. \n${sms}")

        startActivity(intent)
    }
}