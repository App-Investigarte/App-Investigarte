package com.app_investigarte.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.app_investigarte.R
import kotlinx.android.synthetic.main.fragment_sub_regions.view.*

class SubRegionsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var root = inflater.inflate(R.layout.fragment_sub_regions, container, false)

        root.cardViecardViewVerAlertas.setOnClickListener() {
         /*   val intent = Intent(activity, AlertasActivity::class.java)
            startActivity(intent)*/
            Toast.makeText(context, "new Activity", Toast.LENGTH_SHORT).show()
        }

        root.cardViewCalendarioComida.setOnClickListener() {
           /* val intent = Intent(activity, CalendarioActivity::class.java)
            startActivity(intent)*/
            Toast.makeText(context, "new Activity", Toast.LENGTH_SHORT).show()
        }

        root.cardViewBaseDatos.setOnClickListener() {
            /*val intent = Intent(activity, BaseDatosActivity::class.java)
            startActivity(intent)*/
            Toast.makeText(context, "new Activity", Toast.LENGTH_SHORT).show()
        }

        root.cardViewEscanearProducto.setOnClickListener() {
           /* val intent = Intent(activity, BarrasActivity::class.java)
            startActivity(intent)  */
            Toast.makeText(context, "new Activity", Toast.LENGTH_SHORT).show()
        }
        return root
    }

}