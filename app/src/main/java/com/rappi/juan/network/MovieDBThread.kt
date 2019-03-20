package com.rappi.juan.network

import android.app.Activity
import android.os.AsyncTask
import android.widget.ListView

import com.google.gson.Gson
import com.rappi.juan.juanrappimovietest.MovieAdapter
import com.rappi.juan.juanrappimovietest.R
import com.rappi.juan.models.MovieDBResult
import com.rappi.juan.util.Utilidades
import android.view.View
import com.rappi.juan.models.Result
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.util.ArrayList

import javax.net.ssl.HttpsURLConnection

class MovieDBThread(private val activity: Activity, private val url: String, private val type: String) : AsyncTask<Void, Void, Void>() {
    private val apiKey: String
    private var movieDBResult: MovieDBResult? = null

    init {
        this.apiKey = "&api_key=4dd8fd0ba2a9e77b20b257dbbbfd85d3"
    }

    override fun doInBackground(vararg o: Void?): Void? {
        try {

            if (Utilidades.isConnected(activity.applicationContext)) {
                val githubEndpoint = URL("$url$apiKey&page=1")
                val connection = githubEndpoint.openConnection() as HttpsURLConnection

                if (connection.responseCode == 200) {
                    val bufferedReader = BufferedReader(InputStreamReader(connection.inputStream))
                    movieDBResult = Gson().fromJson<MovieDBResult>(bufferedReader, MovieDBResult::class.java)
                    Utilidades.setObjectCache(movieDBResult!!, type, activity)

                    for (tmp in movieDBResult!!.results!!) {
                        val path = activity.applicationContext.filesDir.path
                        val posterPath = "https://image.tmdb.org/t/p/w185/" + tmp.poster_path!!
                        Utilidades.downloadFile(posterPath, path)
                    }
                }
                connection.disconnect()
            } else {
                movieDBResult = Utilidades.getObjectCache(type, activity) as MovieDBResult
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }

    override fun onPostExecute(o: Void?) {
        super.onPostExecute(o)
        val listView = activity.findViewById<View>(R.id.movie_list) as ListView
        val movieAdapter = MovieAdapter(activity, if (movieDBResult != null) movieDBResult!!.results!! else ArrayList<Result>())
        listView.adapter = movieAdapter
        movieAdapter.notifyDataSetChanged()
    }
}
