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

class MovieAdapter(private val actividad: Activity, private val sList: List<Result>) : BaseAdapter() {

    private val mInflator: LayoutInflater

    init {
        this.mInflator = LayoutInflater.from(actividad)
    }

    override fun getCount(): Int {
        return sList.size
    }

    override fun getItem(position: Int): Any {
        return sList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val view: View?
        val vh: ListRowHolder
        if (convertView == null) {
            view = this.mInflator.inflate(R.layout.movie_row, parent, false)
            vh = ListRowHolder(view)
            view.tag = vh
        } else {
            view = convertView
            vh = view.tag as ListRowHolder
        }

        val imageNameWithPath = actividad.applicationContext.filesDir.path + '/'.toString() + sList[position].poster_path
        val img = File(imageNameWithPath)
        vh.imagen!!.setImageBitmap(BitmapFactory.decodeFile(img.toString()))
        vh.nombre.text = sList[position].title
        vh.director.text = sList[position].original_language
        vh.fecha.text = sList[position].release_date

        view!!.setOnClickListener {
            val intent = Intent(actividad, MovieDetailActivity::class.java)
            intent.putExtra("selectedMovie", sList[position])
            actividad.startActivity(intent)
        }

        return view
    }
}

class ListRowHolder(row: View?) {
    public val imagen: ImageView
    public val nombre: TextView
    public val director: TextView
    public val fecha: TextView

    init {
        this.imagen = row?.findViewById(R.id.movieImage) as ImageView
        this.nombre = row?.findViewById(R.id.movieName) as TextView
        this.director = row?.findViewById(R.id.movieDirector) as TextView
        this.fecha = row?.findViewById(R.id.movieDate) as TextView

    }
}