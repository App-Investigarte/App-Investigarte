package com.app_investigarte.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.app_investigarte.R
import com.app_investigarte.databinding.FragmentSubRegionsBinding

//es una función que se esta implementando nueva por ahora ignorar esta clase
class SubRegionsFragment : Fragment() {

    private var _binding: FragmentSubRegionsBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSubRegionsBinding.inflate(inflater, container, false)
        var view = binding.root
        var root = binding

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

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}