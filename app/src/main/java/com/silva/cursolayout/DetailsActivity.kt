package com.silva.cursolayout

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar


class DetailsActivity : AppCompatActivity() {
    private val cameraPermission: Int = 85
    private lateinit var placeInfo: Place
    private lateinit var placeName: TextView
    private lateinit var placeAddress: TextView
    private lateinit var placeSchedule: TextView
    private lateinit var placeContact: TextView
    private lateinit var initiateButton: Button
    private lateinit var layout: ConstraintLayout
    private lateinit var callButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        placeInfo = intent.getSerializableExtra("Info") as Place
        findPlaces()
        setInfo()
        initListeners()
    }

    private fun findPlaces() {
        placeName = findViewById(R.id.place_name)
        placeAddress = findViewById(R.id.place_address)
        placeSchedule = findViewById(R.id.schedule_info)
        placeContact = findViewById(R.id.contact_info)
        initiateButton = findViewById(R.id.button_initiate_visit)
        layout = findViewById(R.id.details_layout)
        callButton = findViewById(R.id.button_call)
    }

    private fun setInfo() {
        placeName.text = placeInfo.name
        placeAddress.text = placeInfo.address
        placeSchedule.text = placeInfo.schedule
        placeContact.text = placeInfo.phoneNumber
    }

    private fun initListeners() {
        initiateButton.setOnClickListener {
            requestCameraPermission()
        }
        callButton.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+placeInfo.phoneNumber))
            startActivity(intent)
        }
    }

    private fun requestCameraPermission() {
        when {
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED -> {
                Toast.makeText(this, "El permiso ya ha sido otorgado", Toast.LENGTH_LONG).show()
            }
            shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)->{
                showSnackbar()
            }
            else -> {
                requestPermissions(
                    arrayOf(Manifest.permission.CAMERA),
                    cameraPermission
                )
            }
        }
    }

    private fun showSnackbar() {
        val snack = Snackbar.make(layout, "Intentamos brindarle un mejor servicio\na los demás ¿Está seguro?", Snackbar.LENGTH_LONG)
        snack.setAction("OK") {
            requestPermissions(
                arrayOf(Manifest.permission.CAMERA),
                cameraPermission
            )
        }
        snack.show()
    }


}