package com.app_investigarte

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.app_investigarte.fragments.MapFragment
import com.google.android.material.navigation.NavigationView


class NavDrawerActivity : AppCompatActivity(),   NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_drawer)

        val toolbar: Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layout)

        toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawe_open,R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
        showFragmentMap()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val itemMapa = (R.id.nav_map)
        val itemArtifact = (R.id.nav_artifact)
        val itemConfig = (R.id.nav_config)
        val itemInfo = (R.id.nav_info)
        val itemExit= (R.id.nav_salir)

        when (item.itemId) {
            itemMapa -> {showFragmentMap()
                Toast.makeText(this,"item Mapa", Toast.LENGTH_SHORT).show()}
            itemArtifact -> { showAllartifat()
                Toast.makeText(this,"item Artefacto", Toast.LENGTH_SHORT).show()
            }
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


    private fun showFragmentMap() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_fragment, MapFragment())
            .setReorderingAllowed(true).addToBackStack(null)
            .commit()
    }

    private fun showAllartifat(){
        var intent: Intent? = null
        intent = Intent(this, ListadoArtefactosActivity::class.java)
        var num = 0
        intent.putExtra("subregion",num)
        startActivity(intent)
    }
//Codigo para cuando queremos colocar un fragment dentro de otro fragment
    /*
public class BlankFragment extends Fragment {

    public static final String TAG = "BlankFragment";

    public BlankFragment() {
        // Required empty public constructor
    }

    public static  BlankFragment newInstance(Bundle params){
        BlankFragment bf = new BlankFragment();
        bf.setArguments(params);
        return bf;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

       FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        ft.replace(R.id.content_fragment_map, new MapFragment());
        ft.commit();
        return view;
    }
}*/
}
