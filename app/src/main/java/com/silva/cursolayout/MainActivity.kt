package com.silva.cursolayout

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var initiateButton: Button
    lateinit var detailsButton: Button
    lateinit var driveButton: ImageButton
    lateinit var downloadButton: Button
    lateinit var placeName: TextView
    lateinit var placeAddress: TextView
    lateinit var placeSchedule: TextView
    lateinit var placeInfo: Place

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initiateButton= findViewById(R.id.button_initiate)
        detailsButton = findViewById(R.id.button_details)
        driveButton = findViewById(R.id.button_drive)
        downloadButton = findViewById(R.id.button_download)
        placeName = findViewById(R.id.interesting_place)
        placeAddress = findViewById(R.id.interesting_place_dir)
        placeSchedule = findViewById(R.id.interesting_place_hour)
        placeInfo = Place(placeName.text.toString(), placeSchedule.text.toString(), "4653 6282", placeAddress.text.toString())


        initListeners()
    }

    fun initListeners(){
        initiateButton.setOnClickListener {
            val nombre = "Herber Sebastian Silva Muñoz"
            val toast = Toast.makeText(this, nombre, Toast.LENGTH_SHORT)
            toast.show()
        }
        detailsButton.setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("Info", placeInfo)
            startActivity(intent)
        }
        driveButton.setOnClickListener{
            val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:14.60233,-90.52421?q=Taqueria El Loco, Ciudad de, 12 Calle 2-51, Cdad. de Guatemala 01009"))
            startActivity(mapIntent)
        }
        downloadButton.setOnClickListener{
            val downloadIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.whatsapp"))
            startActivity(downloadIntent)
        }
    }
}