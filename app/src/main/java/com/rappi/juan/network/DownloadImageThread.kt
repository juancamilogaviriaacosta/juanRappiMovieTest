package com.rappi.juan.network

import android.app.Activity
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.view.View
import android.widget.ImageView
import com.rappi.juan.juanrappimovietest.R
import com.rappi.juan.util.Utilidades
import java.io.File

class DownloadImageThread(private val activity: Activity, private val poster_path: String) : AsyncTask<Void, Void, Void>() {

    override fun doInBackground(vararg o: Void?): Void? {
        try {
            if (Utilidades.isConnected(activity.applicationContext)) {
                val path = activity.applicationContext.filesDir.path
                val posterPath = "https://image.tmdb.org/t/p/w500/$poster_path"
                Utilidades.downloadFile(posterPath, path)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }

    override fun onPostExecute(o: Void?) {
        super.onPostExecute(o)
        val imagenDetalle = activity.findViewById<View>(R.id.imagenDetalle) as ImageView
        val imageNameWithPath = activity.applicationContext.filesDir.path + '/'.toString() + poster_path
        val img = File(imageNameWithPath)
        imagenDetalle.setImageBitmap(BitmapFactory.decodeFile(img.toString()))
    }


}
