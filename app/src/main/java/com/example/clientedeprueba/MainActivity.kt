package com.example.clientedeprueba

import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.content_main.view.*

class MainActivity : AppCompatActivity() {

    var number = 0
    var number2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val url = "http://192.168.1.52:40000/cancion.mp3" // your URL here
        val mediaPlayer: MediaPlayer? = MediaPlayer().apply {
            setAudioStreamType(AudioManager.STREAM_MUSIC)
            setDataSource(url)
            prepare() // might take long! (for buffering, etc)
            start()
        }


        buttonSendRequest.setOnClickListener{
            if (number <4) {
                requestToServer()
            }
            else {
                number=0
            }
        }
        botonCreador.setOnClickListener{
            requestToServer2()
        }

        botonfrases.setOnClickListener{
            if (number2 <4) {
                requestToServer3()
            }
            else {
                number2=0
            }
        }

        consejos.setOnClickListener{
            val intent = Intent(this, Main2Activity::class.java)
            startActivity(intent)
        }

        anuncio.setOnClickListener{
            val intent = Intent(this, Main3Activity::class.java)
            startActivity(intent)
        }











    }


    fun verEnPantalla(s : String)
    {
        val txt = findViewById(R.id.textView2) as TextView
        txt.setText(s)
    }

    private fun requestToServer(){
        // Instantiate the RequestQueue with the cache and network. Start the queue.
        val Queue = Volley.newRequestQueue(this)

        val url = "http://192.168.1.52:40000/rutina"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                var respuesta = response.getJSONArray("list").getJSONObject(number).getString("rutina")
                number ++
                textViewMessage.text=respuesta
            },
            Response.ErrorListener { error ->
                // TODO: Handle error
            }
        )

        Queue.add(jsonObjectRequest)


    }

    private fun requestToServer3(){
        // Instantiate the RequestQueue with the cache and network. Start the queue.
        val Queue = Volley.newRequestQueue(this)

        val url = "http://192.168.1.52:40000/frases"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                var respuesta3 = response.getJSONArray("list").getJSONObject(number2).getString("frases")
                number2++
                textView2.text=respuesta3
            },
            Response.ErrorListener { error ->
                // TODO: Handle error
            }
        )

        Queue.add(jsonObjectRequest)


    }

    private fun requestToServer2(){
        // Instantiate the RequestQueue with the cache and network. Start the queue.
        val Queue2 = Volley.newRequestQueue(this)

        val url = "http://192.168.1.52:40000/creador"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                var respuesta2 = response.getString("creador")
                textCreador.setText(respuesta2)
            },
            Response.ErrorListener { error ->
                // TODO: Handle error
            }
        )

        Queue2.add(jsonObjectRequest)


    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
