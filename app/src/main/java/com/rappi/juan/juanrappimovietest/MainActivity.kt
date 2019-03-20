package com.rappi.juan.juanrappimovietest

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import com.rappi.juan.util.Utilidades
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        about.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        val boton_popular = findViewById<View>(R.id.boton_popular) as Button
        boton_popular.setOnClickListener {
            val intent = Intent(this@MainActivity, PopularActivity::class.java)
            startActivity(intent)
        }

        val boton_top_rated = findViewById<View>(R.id.boton_top_rated) as Button
        boton_top_rated.setOnClickListener {
            val intent = Intent(this@MainActivity, TopratedActivity::class.java)
            startActivity(intent)
        }

        val boton_upcoming = findViewById<View>(R.id.boton_upcoming) as Button
        boton_upcoming.setOnClickListener {
            val intent = Intent(this@MainActivity, UpcomingActivity::class.java)
            startActivity(intent)
        }

        val boton_search = findViewById<View>(R.id.boton_search) as Button
        boton_search.setOnClickListener {
            val intent = Intent(this@MainActivity, SearchActivity::class.java)
            startActivity(intent)
        }

        val fab = findViewById<View>(R.id.about) as FloatingActionButton
        fab.setOnClickListener {
            val url = "https://api.whatsapp.com/send?phone=573138593337"

            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return Utilidades.onNavigationItemSelected(this, item)
    }
}