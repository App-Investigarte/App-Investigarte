package com.app_investigarte

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


class NavDrawerActivity : AppCompatActivity(),   NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        val toolbar: Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layout)

        toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawe_open,R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var itemMapa = (R.id.nav_map)
        var itemArtifact = (R.id.nav_artifact)
        var itemConfig = (R.id.nav_config)
        var itemInfo = (R.id.nav_info)
        var itemExit= (R.id.nav_salir)

        when (item.itemId) {
            itemMapa -> Toast.makeText(this,"item Mapa", Toast.LENGTH_SHORT).show()
            itemArtifact -> Toast.makeText(this,"item Artefacto", Toast.LENGTH_SHORT).show()
            itemConfig -> Toast.makeText(this,"item Config", Toast.LENGTH_SHORT).show()
            itemInfo -> Toast.makeText(this,"item Info", Toast.LENGTH_SHORT).show()
            itemExit ->{
                finishAndRemoveTask()
            }
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onPostCreate(savedInstanceState: Bundle?){
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean{
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return  super.onOptionsItemSelected(item)
    }


}