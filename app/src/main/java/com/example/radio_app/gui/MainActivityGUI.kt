package com.example.radio_app.gui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.radio_app.R
import com.example.radio_app.dataHandling.DataHandling

class MainActivityGUI : ComponentActivity() {
    private lateinit var btnCurrentTitle: Button
    private lateinit var btnPlaylistReview: Button
    private lateinit var btnModeratorReview: Button
    private lateinit var btnSongWish: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        btnCurrentTitle = findViewById(R.id.btnCurrentTitle)
        btnPlaylistReview = findViewById(R.id.btnPlaylistReview)
        btnModeratorReview = findViewById(R.id.btnModeratorReview)
        btnSongWish = findViewById(R.id.btnSongWish)


        btnCurrentTitle.setOnClickListener {
            val intent = Intent(this, CurrentSongGUI::class.java)
            startActivity(intent)
        }

        btnPlaylistReview.setOnClickListener {
            val intent = Intent(this, ReviewPlaylistGUI::class.java)
            startActivity(intent)
        }

        btnModeratorReview.setOnClickListener {
            val intent = Intent(this, ReviewModeratorGUI::class.java)
            startActivity(intent)
        }

        btnSongWish.setOnClickListener {
            val intent = Intent(this, SongWishGUI::class.java)
            startActivity(intent)
        }
    }
}
