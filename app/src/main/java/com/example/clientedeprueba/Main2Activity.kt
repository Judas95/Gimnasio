package com.example.clientedeprueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        descargar.setOnClickListener{
            val intent = Intent(this, Main4Activity::class.java)
            startActivity(intent)
        }
    }
}
