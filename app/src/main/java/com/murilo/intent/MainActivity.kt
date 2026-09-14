package com.murilo.intent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnExplicacao = findViewById<Button>(R.id.btnExplicacao)
        btnExplicacao.setOnClickListener {
            val exIntent = Intent(this, Explicacao::class.java)
            startActivity(exIntent)
        }

        val btnDiferenca = findViewById<Button>(R.id.btnDiferenca)
        btnDiferenca.setOnClickListener {
            val difIntent = Intent(this, Diferenca::class.java)
            startActivity(difIntent)
        }

        val btnExplicita = findViewById<Button>(R.id.btnExplicita)
        btnExplicita.setOnClickListener {
            val explicIntent = Intent(this, SecondActivity::class.java)
            startActivity(explicIntent)
        }

        val btnImplicito = findViewById<Button>(R.id.btnImplicito)
        btnImplicito.setOnClickListener {
            val implIntent = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.google.com"))
            startActivity(implIntent)
        }
    }
}