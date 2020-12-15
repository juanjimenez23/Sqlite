package com.example.sqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    var myNotasDbHelper:NotasDbHelper?=null
    val DB_NAME = "notas.db"
    val DB_VERSION = 1

    var fabAdd:FloatingActionButton?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fabAdd = findViewById(R.id.fabAddNotas)

        myNotasDbHelper = NotasDbHelper(this,DB_NAME,null,DB_VERSION)
        myNotasDbHelper!!.open()
        //myNotasDbHelper!!.addNota("Prueba","Contenido de la Nota")

        fabAdd!!.setOnClickListener{
            val i = Intent(this, AddNotaActivity::class.java)
            startActivity(i)
        }

        fun onDestroy(){

        }

    }
}