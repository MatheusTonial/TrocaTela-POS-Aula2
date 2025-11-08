package com.tonial.trocatela

import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ListarActivity : AppCompatActivity() {

    private lateinit var lvProdutos: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_listar)

        lvProdutos = findViewById(R.id.lvProdutos)

        lvProdutos.setOnItemClickListener{ parent, view, position, id ->
            val cod = position + 1
            Toast.makeText(this, "Clicou em ${cod}", Toast.LENGTH_SHORT).show()

            intent.putExtra("cod", cod)
            setResult(RESULT_OK, intent)

            finish()
        }

    }
}