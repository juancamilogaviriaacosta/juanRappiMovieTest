package com.rappi.juan.juanrappimovietest

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

import com.rappi.juan.models.Result

import java.io.File

class MovieAdapter(private val actividad: Activity, private val lista: List<Result>) : BaseAdapter() {

    init {
        inflater = actividad.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getCount(): Int {
        return lista.size
    }

    override fun getItem(position: Int): Any {
        return lista[position]
    }

    override fun getItemId(position: Int): Long {
        return java.lang.Long.valueOf(lista[position].id!!.toLong())
    }

    override fun getView(position: Int, convertView: View, parent: ViewGroup): View {
        val holder: Holder

        val temp = lista[position]
        var row: View? = convertView
        if (row == null) {
            row = inflater.inflate(R.layout.movie_row, null)
            holder = Holder()
            holder.imagen = row!!.findViewById<View>(R.id.movieImage) as ImageView
            holder.nombre = row.findViewById<View>(R.id.movieName) as TextView
            holder.director = row.findViewById<View>(R.id.movieDirector) as TextView
            holder.fecha = row.findViewById<View>(R.id.movieDate) as TextView
            row.tag = holder
        } else {
            holder = row.tag as Holder
        }

        val imageNameWithPath = actividad.applicationContext.filesDir.path + '/'.toString() + temp.poster_path
        val img = File(imageNameWithPath)
        holder.imagen!!.setImageBitmap(BitmapFactory.decodeFile(img.toString()))

        holder.nombre!!.text = temp.title
        holder.director!!.text = temp.original_language
        holder.fecha!!.text = temp.release_date

        row.setOnClickListener {
            val intent = Intent(actividad, MovieDetailActivity::class.java)
            intent.putExtra("selectedMovie", temp)
            actividad.startActivity(intent)
        }
        return row
    }

    inner class Holder {
        internal var imagen: ImageView? = null
        internal var nombre: TextView? = null
        internal var director: TextView? = null
        internal var fecha: TextView? = null
    }

    companion object {
        private lateinit var inflater: LayoutInflater
    }
}
