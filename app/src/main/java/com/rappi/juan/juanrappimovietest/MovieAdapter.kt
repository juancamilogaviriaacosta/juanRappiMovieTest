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

        vh.label.text = sList[position].title
        return view
    }
}

class ListRowHolder(row: View?) {
    public val label: TextView

    init {
        this.label = row?.findViewById(R.id.movieName) as TextView
    }
}