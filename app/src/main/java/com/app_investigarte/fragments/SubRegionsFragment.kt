package com.app_investigarte.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.app_investigarte.ListadoArtefactos.ListadoArtefactosActivity
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

        root.cvUraba.setOnClickListener() { showSubregions(8)}

        root.cvOccidente.setOnClickListener() { showSubregions(5)}

        root.cvSuroeste.setOnClickListener() { showSubregions(7)}

        root.cvNorte.setOnClickListener() { showSubregions(4)}

        root.cvValleAburra.setOnClickListener() { showSubregions(9)}

        root.cvBajoCauca.setOnClickListener() { showSubregions(1)}

        root.cvMagdalenaMedio.setOnClickListener() { showSubregions(2)}

        root.cvNordeste.setOnClickListener() { showSubregions(3)}

        root.cvOriente.setOnClickListener() { showSubregions(6)}

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showSubregions(subregion: Int){

        val intent = Intent(context, ListadoArtefactosActivity::class.java)
        intent.putExtra("subregion", subregion)
        startActivity(intent)
    }
}