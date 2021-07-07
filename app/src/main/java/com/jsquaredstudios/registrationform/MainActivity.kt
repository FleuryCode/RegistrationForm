package com.jsquaredstudios.registrationform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            setupButton()
            setupSpinner()


    }



    private fun setupSpinner() {
        val spinnerValues = arrayOf("Mr.", "Mrs.", "Ms.")
        val spinnerAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerValues)
        spinner_title.adapter = spinnerAdapter
    }

    private fun setupButton() {
        button_preview.setOnClickListener {
            onPreviewClicked()
        }
    }

    private fun onPreviewClicked() {
        val info = RegistrationInfo(
            spinner_title.selectedItem as String,
            edit_text_first_name.text.toString(),
            edit_text_last_name.text.toString(),
            edit_text_contact_number.text.toString(),
            edit_text_email.text.toString(),
            edit_text_password.text.toString()
        )

        val previewActivityIntent = Intent(this, PreviewActivity::class.java)
        previewActivityIntent.putExtra("Info", info)
        startActivity(previewActivityIntent)

    }
}