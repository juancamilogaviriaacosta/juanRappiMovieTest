package com.rappi.juan.juanrappimovietest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.rappi.juan.models.Result
import com.rappi.juan.network.DownloadImageThread

import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {

    private var selectedMovie: Result? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        setSupportActionBar(toolbar)

        selectedMovie = intent.extras!!.getSerializable("selectedMovie") as Result

        if(selectedMovie!!.poster_path != null) {
            val dit = DownloadImageThread(this, selectedMovie!!.poster_path!!)
            dit.execute()
        }

        (findViewById<View>(R.id.title1) as TextView).text = selectedMovie!!.title
        (findViewById<View>(R.id.popularity1) as TextView).text = selectedMovie!!.popularity.toString()
        (findViewById<View>(R.id.vote_average1) as TextView).text = selectedMovie!!.vote_average.toString()
        (findViewById<View>(R.id.original_language1) as TextView).text = selectedMovie!!.original_language
        (findViewById<View>(R.id.release_date1) as TextView).text = selectedMovie!!.release_date
        (findViewById<View>(R.id.overview1) as TextView).text = selectedMovie!!.overview
    }

}
