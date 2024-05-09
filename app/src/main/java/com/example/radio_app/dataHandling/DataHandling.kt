package com.example.radio_app.dataHandling

import com.example.radio_app.communication.Interface
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.StringReader

// Klasse dient dazu die Daten aus/zu der Schnittstelle ud Benutzeroberfläche zu verwalten
class DataHandling {
    private var inter = Interface()

    fun getCurrentSong(): Song? {
        val xmlPullParser = XmlPullParserFactory.newInstance().newPullParser()
        xmlPullParser.setInput(StringReader(inter.getCurrentSong()))

        var eventType = xmlPullParser.eventType
        var title = ""
        var album = ""
        var artist = ""

        while (eventType != XmlPullParser.END_DOCUMENT) {
            when (eventType) {
                XmlPullParser.START_TAG -> {
                    when (xmlPullParser.name) {
                        "title" -> title = xmlPullParser.nextText()
                        "album" -> album = xmlPullParser.nextText()
                        "artist" -> artist = xmlPullParser.nextText()
                    }
                }
                XmlPullParser.END_TAG -> {
                    if (xmlPullParser.name == "song") {
                        return Song(title, album, artist)
                    }
                }
            }
            eventType = xmlPullParser.next()
        }

        return null
    }

    fun addReviewPlaylist(text:String): Int{
        return inter.addReview(ReviewPlaylist(text))
    }

    fun addReviewModerator(text:String): Int{
        return inter.addReview(ReviewModerator(text))
    }

    fun addWishSong(title:String, album:String, artist:String): Int{
        return inter.addWishSong(SongWish(title, album, artist))
    }

    fun informModerator(): Int{
        return inter.informModerator()
    }

}