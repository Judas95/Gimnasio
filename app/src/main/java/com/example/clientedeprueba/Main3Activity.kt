package com.example.clientedeprueba

import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main3.*
import kotlinx.android.synthetic.main.content_main.*

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)


        peticion1.setOnClickListener{
            requestToServer()
        }

        peticion2.setOnClickListener{
            requestToServer2()
        }

        peticion3.setOnClickListener{
            requestToServer3()
        }




    }

    private fun requestToServer(){

        val Queue = Volley.newRequestQueue(this)

        val url = "http://192.168.1.52:40000/bigpecho"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                var respuesta = response.getString("bigpecho")
                textView7.setText(respuesta)
            },
            Response.ErrorListener { error ->
                // TODO: Handle error
            }
        )

        Queue.add(jsonObjectRequest)


    }

    private fun requestToServer2(){

        val Queue = Volley.newRequestQueue(this)

        val url = "http://192.168.1.52:40000/piernas"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                var respuesta = response.getString("piernas")
                textView8.setText(respuesta)
            },
            Response.ErrorListener { error ->
                // TODO: Handle error
            }
        )

        Queue.add(jsonObjectRequest)


    }

    private fun requestToServer3(){

        val Queue = Volley.newRequestQueue(this)

        val url = "http://192.168.1.52:40000/cabeza"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                var respuesta = response.getString("cabeza")
                textView9.setText(respuesta)
            },
            Response.ErrorListener { error ->
                // TODO: Handle error
            }
        )

        Queue.add(jsonObjectRequest)


    }
}
