package com.example.webapi2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.koushikdutta.ion.Ion
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun imgbtnOnClick(view: View){
        val url = "https://api.thecatapi.com/v1/images/search"
        Ion.with(this)
            .load(url)
            .asString()
            .setCallback{err, result ->
                dataIsle(result)
            }
    }

    fun dataIsle(data: String){
        val json = JSONArray(data)
        val eleman1 = json.getJSONObject(0)
        val image_url = eleman1.getString("url")

        Picasso.get()
            .load(image_url)
            .into(imageButton)
    }
}
