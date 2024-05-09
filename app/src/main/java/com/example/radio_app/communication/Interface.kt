package com.example.radio_app.communication

import com.example.radio_app.dataHandling.Review
import com.example.radio_app.dataHandling.SongWish

// Dient aktuell als Stub und wird durch korrekte Version ersetzt
class Interface {
    fun getCurrentSong(): String {
        return "<song><title>Boulevard of Broken Dreams</title><album>American Idiot</album><artist>Green Day</artist></song>"
    }

    fun addReview(review: Review): Int{
        return 201
    }

    fun addWishSong(review: SongWish): Int{
        return 201
    }

    fun informModerator(): Int{
        return 201
    }
}