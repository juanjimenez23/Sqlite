package com.example.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.sql.SQLException

class NotasDbHelper (context: Context?,
                     name:String?,
                     factory:SQLiteDatabase.CursorFactory?,
                     version:Int):SQLiteOpenHelper
    (context,name,factory,version){
    val NOMBRE_TABLA = "notas"

    val _ID = "id"
    val TITLE = "titulo"
    val CONTENT = "contenido"

    var database:SQLiteDatabase?=null

    val QUERY_CREATE_TABLE = "CREATE TABLE $NOMBRE_TABLA " +
            "($_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "$TITLE TEXT NOT NULL, " +
            "$CONTENT TEXT);"


    override fun onCreate(p0: SQLiteDatabase?) {
        p0!!.execSQL(QUERY_CREATE_TABLE)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0!!.execSQL("DROP TABLE IF EXISTS $NOMBRE_TABLA")
        onCreate(p0)
    }


    @Throws(SQLException::class)
    fun open(){
        database=this.writableDatabase
    }

    override fun close(){
        super.close()
        database!!.close()
    }

//Insertar datos en la tabla
    fun  addNota(titulo:String, contenido:String){
        val contentValues = ContentValues()
        contentValues.put(TITLE,titulo)
        contentValues.put(CONTENT,contenido)

        database!!.insert(NOMBRE_TABLA,null,contentValues)
    }



}