package com.jsquaredstudios.registrationform

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_preview.*

class PreviewActivity : AppCompatActivity() {

    private lateinit var info: RegistrationInfo


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)
        retrieveInfo()
        displayInfo()
        setupButton()


    }

    private fun retrieveInfo() {
        info = intent.getSerializableExtra("Info") as RegistrationInfo
    }


    private fun displayInfo() {
        text_view_preview_name.text = info.getFullName()
        text_view_preview_email.text = info.email
        text_view_preview_phone.text = info.contactNumber


    }


    private fun setupButton() {
        button_submit.setOnClickListener {
            Toast.makeText(this, "Information Submitted! Thank You!", Toast.LENGTH_LONG).show()
        }

        text_view_preview_email.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:${info.email}")
            startActivity(intent)
        }

        text_view_preview_phone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${info.contactNumber}")
            startActivity(intent)
        }
    }


}