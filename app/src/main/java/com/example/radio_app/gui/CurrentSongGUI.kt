package com.example.radio_app.gui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.radio_app.R
import com.example.radio_app.dataHandling.DataHandling
import com.example.radio_app.dataHandling.Song

class CurrentSongGUI : ComponentActivity() {
    private var dataHandler = DataHandling()
    private lateinit var currentSong:Song
    private lateinit var btnBack: Button

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.current_song)

        val titleTextView = findViewById<TextView>(R.id.songTextView)
        val albumTextView = findViewById<TextView>(R.id.albumTextView)
        val artistTextView = findViewById<TextView>(R.id.interpreterTextView)

        val existingTitleText = titleTextView.text.toString()
        val existingAlbumText = albumTextView.text.toString()
        val existingArtistText = artistTextView.text.toString()

        if (dataHandler.getCurrentSong() != null)
            currentSong = dataHandler.getCurrentSong()!!
            val additionalTitle = currentSong.title
            val additionalAlbum = currentSong.album
            val additionalArtist = currentSong.artist

        titleTextView.text = "$existingTitleText $additionalTitle"
        albumTextView.text = "$existingAlbumText $additionalAlbum"
        artistTextView.text = "$existingArtistText $additionalArtist"

        btnBack = findViewById(R.id.btnBack)

        btnBack.setOnClickListener {
        //    val intent = Intent(this, MainActivityGUI::class.java)
        //    startActivity(intent)
            finish()
        }
    }

}