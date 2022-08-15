package com.silva.cursolayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {
    lateinit var placeInfo: Place
    lateinit var placeName: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        placeInfo = intent.getSerializableExtra("Info") as Place
        placeName = findViewById(R.id.place_name)
        placeName.setText(placeInfo.name)
    }
}