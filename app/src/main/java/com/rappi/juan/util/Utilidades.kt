package com.rappi.juan.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.view.MenuItem
import android.view.View
import com.rappi.juan.juanrappimovietest.AboutActivity
import com.rappi.juan.juanrappimovietest.MainActivity
import com.rappi.juan.juanrappimovietest.PopularActivity
import com.rappi.juan.juanrappimovietest.R
import com.rappi.juan.juanrappimovietest.SearchActivity
import com.rappi.juan.juanrappimovietest.TopratedActivity
import com.rappi.juan.juanrappimovietest.UpcomingActivity
import java.io.IOException

class Utilidades {

    companion object {

        fun onNavigationItemSelected(actividad: Activity, item: MenuItem): Boolean {
            val id = item.itemId

            if (id == R.id.nav_camera) {
                val intent = Intent(actividad, MainActivity::class.java)
                actividad.startActivity(intent)
            } else if (id == R.id.nav_gallery) {
                val intent = Intent(actividad, PopularActivity::class.java)
                actividad.startActivity(intent)
            } else if (id == R.id.nav_slideshow) {
                val intent = Intent(actividad, TopratedActivity::class.java)
                actividad.startActivity(intent)
            } else if (id == R.id.nav_manage) {
                val intent = Intent(actividad, UpcomingActivity::class.java)
                actividad.startActivity(intent)
            } else if (id == R.id.nav_share) {
                val intent = Intent(actividad, AboutActivity::class.java)
                actividad.startActivity(intent)
            } else if (id == R.id.nav_send) {
                val intent = Intent(actividad, SearchActivity::class.java)
                actividad.startActivity(intent)
            }

            actividad.finish()
            val drawer = actividad.findViewById<View>(R.id.drawer_layout) as DrawerLayout
            drawer.closeDrawer(GravityCompat.START)
            return true
        }

        fun isConnected(context: Context): Boolean {
            return true
        }

        fun setObjectCache(obj: Any, name: String, activity: Activity): Boolean {
            return true;
        }

        fun getObjectCache(name: String, activity: Activity): Any? {
            return null;
        }

        @Throws(IOException::class)
        fun downloadFile(fileURL: String, saveDir: String) {

        }
    }
}