package com.app_investigarte

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.app_investigarte.ListadoArtefactos.ListadoArtefactosActivity
import com.app_investigarte.fragments.Map.MapFragment
import com.app_investigarte.fragments.SubRegionsFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.navigation.NavigationView


class NavDrawerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //se recuperan los datos del usuario logeado
        val pref = getSharedPreferences(getString(R.string.PREFERENS), MODE_PRIVATE)
        val email = pref.getString("email","")
        val name = pref.getString("name", "")

        //se le pasa la vista que tendrá el menu de navegación lateral y al fragment principal que contendrá las vista.
        setContentView(R.layout.activity_nav_drawer)

        //se hace referencia a el id de la Barra superior
        val toolbar: Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        //se hase referencia a el id del layout qeu contendrá el menu de navegación lateral y al fragment principal que contendrá las vista.
        drawer = findViewById(R.id.drawer_layout)

        toggle = ActionBarDrawerToggle(
            this,
            drawer,
            toolbar,
            R.string.navigation_drawe_open,
            R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        // Se hace referencia a el id del menu de navegación lateral
        val navigationView: NavigationView = findViewById(R.id.nav_view)
        // Escuchamos los items seleccionados del menu, haciendo contexto que los items sean escuchados con el contexto de este activity
        navigationView.setNavigationItemSelectedListener(this)

        val headerTvCorreo = navigationView.getHeaderView(0).findViewById<TextView>(R.id.nav_header_tv_correo)
        val headerTvName = navigationView.getHeaderView(0).findViewById<TextView>(R.id.nav_header_tv_name)
        //personalizamos la cabecera del navigationView con el Correo y el nombre del usuari@ logeado
        headerTvCorreo.text = email
        headerTvName.text = name
        // Mostramos el Fragment del Mapa con el Fragment Principal.
        showFragmentMap()
    }


    // Sobre-escribimos la función para cuando un item del menu Lateral es presionado
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val itemMapa = (R.id.nav_map)
        val itemArtifact = (R.id.nav_artifact)
        val itemSubregions = (R.id.nav_sub_region)
        val itemConfig = (R.id.nav_config)
        val itemExit = (R.id.nav_salir)

        // Según el id del item presionado realizamos su acción correspondiente
        when (item.itemId) {
            itemMapa -> showFragmentMap()  // Mostramos el Fragment
            itemArtifact -> showAllartifat()   // Pasamos a al activity para mostrar todos los artefactos
            itemSubregions -> showAllSubregions()
            itemConfig -> Toast.makeText(this, "item Config", Toast.LENGTH_SHORT).show()
            itemExit -> exit()       // Finalizamos la aplicación y deslogeamos al usuario
        }
        drawer.closeDrawer(GravityCompat.START)

        // El método retorna un Buleano asi que devolvemos un verdadero indicado de que realizo la operación exitosamente
        return true
    }

    private fun showAllSubregions() {
        //Reemplazamos en el Fragment Principal por el Fragment de las subregiones
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_fragment,
                SubRegionsFragment()
            )
            .setReorderingAllowed(true).addToBackStack(null)
            .commit()
    }

    // Metodos del Menu lateral generados automáticamente
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    // Función para Mostrar el Fragment del Mapa.
    private fun showFragmentMap() {
        //Reemplazamos en el Fragment Principal por el Fragment del Mapa
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_fragment,
                MapFragment()
            )
            .setReorderingAllowed(true).addToBackStack(null)
            .commit()
    }


    //Función para cerrar la app y deslogear el usuario.
    private fun exitActivity() {

        //Borrar datos del Usuario
        val prefs: SharedPreferences.Editor = getSharedPreferences(
            getString(R.string.PREFERENS),
            Context.MODE_PRIVATE
        ).edit()
        prefs.clear()
        prefs.apply()

        //finalizar activity y removerla de la lista de tareas.
        finishAndRemoveTask()
    }

    // Función Para iniciar la activity que muestra todos los artefactos.
    private fun showAllartifat() {
        val intent = Intent(this, ListadoArtefactosActivity::class.java)
        // Le pasamos como parámetro el cero para indicarle que tiene que mostrar todos los artefactos.
        intent.putExtra("subregion", 0)
        startActivity(intent)
    }


    // Aun falta Corregir el onBackPressed
    override fun onBackPressed() {
        /*  val fragment =
              this.supportFragmentManager.findFragmentById(R.id.container_fragment)
          (fragment as? IOnBackPressed)?.onBackPressed()?.not()?.let {
              super.onBackPressed()
          }*/
        close()
    }

    fun close() {
        val title = getString(R.string.title_exit_alert)
        val message = getString(R.string.message_exit_alert)
        val btnPositive = getString(R.string.positive_exit_alert)
        MaterialAlertDialogBuilder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(
                btnPositive
            ) { dialogInterface: DialogInterface?, i: Int -> finishAndRemoveTask() }
            .show()
    }

    fun exit() {
        val title = getString(R.string.title_exit_alert)
        val message = getString(R.string.message_exit_alert) + " \nLa sesión iniciada se cerrará por completo "
        val btnPositive = getString(R.string.positive_exit_alert)
        val btnNegativo = getString(R.string.negative_exit_alert)
        MaterialAlertDialogBuilder(this)
            .setTitle(title)
            .setMessage(message)
            .setNegativeButton(
                btnNegativo
            ){dialogInterface: DialogInterface?, I: Int -> }
            .setPositiveButton(
                btnPositive
            ) { dialogInterface: DialogInterface?, i: Int -> exitActivity() }
            .show()
    }

// Código para cuando queremos colocar un fragment dentro de otro fragment
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
