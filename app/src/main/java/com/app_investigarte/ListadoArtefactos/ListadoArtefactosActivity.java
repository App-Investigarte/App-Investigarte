package com.app_investigarte.ListadoArtefactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.app_investigarte.R;
import com.app_investigarte.database.DatabaseAccess;

import java.util.ArrayList;

public class ListadoArtefactosActivity extends AppCompatActivity

{

    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;
    // Se Crea un ArrayList Con la estructura de el RecyclerViewModel es decir la estructura qeu tendrían los CartView de los artefactos.
    ArrayList<RecyclerViewModel>ArtifactList;
    RecyVWAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_artefactos);

        //recuperamos el valor enviado de la activity anterior para saver qeu subregion fue seleccionada
        Bundle parametros = this.getIntent().getExtras();
        int subregion = parametros.getInt("subregion");

        //si la subregion es 0 se inicializa la data de todos los artefactos
        if(subregion == 0){
            initAllData();
        }else{ // si la subregion no es 0 se inicializa la data de los artefactos de la subregion especifica
            // inicializa la data y se le pasa la subregion a consultar.
            initData(subregion);
        }

        initRecyclerView();
    }


    private void initAllData(){
        //se Crea o instancia un ArrayList
        ArtifactList=new ArrayList<>();
        //se instancia la base de datos y se abre para poder escucharla y modificarla.
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();

        // se guarda en un entero la cantidad de todos los artefacto actuales  consultados en la base de datos
        int cantidadDatos = databaseAccess.cantidadAllArtefactos();
        // se guarda en una matriz los datos obtenidos en al base de datos de todos los artefactos.
        String [][]consultaregistro = databaseAccess.getAllArtifact(cantidadDatos);
        //se cierra la base de datos para evitar vulnerabilidad de seguridad.
        databaseAccess.close();
        // Se recorre la matriz con un ciclo for asta la cantidad de artefactos que es la cantidadDatos obtenida con anterioridad.
        for(int i = 0; i < cantidadDatos; i++){
            //se recupera el id del artefacto pasándolo a entero
            //se recupera la imagen del artefacto
            //se recupera la descripción del artefacto
            //se agrega en el arrayList todos los artefacto consultados, creando objetos del RecyclerViewModel con la estructura de los artefactos par el cartView.
            ArtifactList.add(new RecyclerViewModel( Integer.parseInt(consultaregistro[i][0]), consultaregistro[i][2],  consultaregistro[i][1]));
        }
    }

    private void initData(int subregion)
    {
        //se Crea o instancia un ArrayList
        ArtifactList=new ArrayList<>();
        //se instancia la base de datos y se abre para poder escucharla y modificarla.
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();

        // se guarda en un entero la cantidad de los artefacto que se encuentran en la subregion seleccionada.
        int cantidadDatos = databaseAccess.CantidadArtefactosSubR(subregion);
        // se guarda en una matriz los datos obtenidos en al base de la subregion seleccionada.
        String [][]consultaregistro = databaseAccess.getArtifactSubregion(subregion, cantidadDatos);
        //se cierra la base de datos para evitar vulnerabilidad de seguridad.
        databaseAccess.close();
        for(int i = 0; i < cantidadDatos; i++){
            //se recupera el id del artefacto pasándolo a entero
            //se recupera la imagen del artefacto
            //se recupera la descripción del artefacto
            //se agrega en el arrayList todos los artefacto consultados, creando objetos del RecyclerViewModel con la estructura de los artefactos par el cartView.
            ArtifactList.add(new RecyclerViewModel( Integer.parseInt(consultaregistro[i][0]), consultaregistro[i][2],  consultaregistro[i][1]));
        }
    }

    // Se inicializa el RecyclerView que es el que muestra la información.
    @SuppressLint("NotifyDataSetChanged")
    private void initRecyclerView()
    {
        //Se ase referencia al id del recyclerView
        recyclerView=findViewById(R.id.artefactos_recycleryview);
        //Se utiliza un gridLayoutManager de 2 columnas para poder Mostrar el contenido en dos columnas.
        gridLayoutManager=new GridLayoutManager(this,2);
        //layoutManager.setOrientation(RecyclerView.VERTICAL);
        //Al recyclerView se Le pasa el layout manager a utilizar que en este caso el el GridLayoutM.
        recyclerView.setLayoutManager(gridLayoutManager);
        //Al el  RecyVWAdapter se le pasa la lista de artefactos a mostrar en el recyclerView.
        adapter=new RecyVWAdapter(ArtifactList);
        //Por ultimo Al recyclerView se le pasa el adapter con todos los artefactos a mostrar.
        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }
}