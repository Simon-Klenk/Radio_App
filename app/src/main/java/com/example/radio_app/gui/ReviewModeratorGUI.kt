package com.example.radio_app.gui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.radio_app.R
import com.example.radio_app.dataHandling.DataHandling

class ReviewModeratorGUI : ComponentActivity() {
    private var dataHandler = DataHandling()
    private lateinit var btnBack: Button
    private lateinit var btnSend: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.review_moderator)
        btnBack = findViewById(R.id.btnBack)
        btnSend = findViewById(R.id.btnSend)

        btnBack.setOnClickListener {
            finish()
        }

        btnSend.setOnClickListener {
            val duration = Toast.LENGTH_SHORT
            val text = findViewById<EditText>(R.id.editTextTextMultiLine).text.toString()
            if (valid(text)) {
                var toastText = ""

                if (dataHandler.addReviewModerator(findViewById<EditText>(R.id.editTextTextMultiLine).text.toString()) == 201) {
                    dataHandler.informModerator()
                    toastText = "Gesendet"
                }
                else
                    toastText = "Fehlgeschlagen"

                val toast = Toast.makeText(this, toastText, duration)
                toast.show()

                finish()
            }
            else {
                val toast = Toast.makeText(this, "Bitte nur Buchstaben und . , ! ? eingeben", duration)
                toast.show()
            }
        }
    }

    // Prüft die Zeichenkette auf erlaubte Zeichen
    private fun valid(input: String): Boolean {
        val regex = Regex("[a-zA-Z.,?!\\s]+")
        return regex.matches(input)
    }

}