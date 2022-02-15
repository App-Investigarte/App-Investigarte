package com.app_investigarte.ListadoArtefactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.app_investigarte.R;
import com.app_investigarte.database.DatabaseAccess;

import java.util.ArrayList;

public class ListadoArtefactosActivity extends AppCompatActivity

{

    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;
    ArrayList<RecyclerViewModel>ArtifactList;
    RecyVWAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_artefactos);

        Bundle parametros = this.getIntent().getExtras();
        Integer subregion = parametros.getInt("subregion");

        if(subregion == 0){
            initAllData();
        }else{
            initData(subregion);
        }
        initRecyclerView();
    }


    private void initAllData(){
        ArtifactList=new ArrayList<>();
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();
        int cantidadDatos = databaseAccess.cantidadAllArtefactos();
        String [][]consultaregistro = databaseAccess.getAllArtifact(cantidadDatos);
        databaseAccess.close();
        int id;
        for(int i = 0; i < cantidadDatos; i++){
            id = Integer.parseInt(consultaregistro[i][0]);
            ArtifactList.add(new RecyclerViewModel( id, consultaregistro[i][2],  consultaregistro[i][1]));
            //  ArtifactList.add(new RecyclerViewModel(R.drawable.circle,  consultaregistro[i][1]));
        }
    }

    private void initData(int subregion)
    {
        ArtifactList=new ArrayList<>();
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();
        int cantidadDatos = databaseAccess.CantidadArtefactosSubR(subregion);
        String [][]consultaregistro = databaseAccess.getArtifactSubregion(subregion, cantidadDatos);
        databaseAccess.close();
        int id;
        for(int i = 0; i < cantidadDatos; i++){
            id = Integer.parseInt(consultaregistro[i][0]);
            ArtifactList.add(new RecyclerViewModel( id, consultaregistro[i][2],  consultaregistro[i][1]));
          //  ArtifactList.add(new RecyclerViewModel(R.drawable.circle,  consultaregistro[i][1]));
        }
    }

    private void initRecyclerView()
    {
        recyclerView=findViewById(R.id.artefactos_recycleryview);
        gridLayoutManager=new GridLayoutManager(this,2);
       // layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter=new RecyVWAdapter(ArtifactList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


/*
    private void artifactList(int subregion)
    {
       DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
       databaseAccess.open();
       int cantidadDatos = databaseAccess.CantidadArtefactosSubR(subregion);
       String [][]consultaregistro = databaseAccess.getArtifactSubregion(subregion, cantidadDatos);
       databaseAccess.close();

      for(int j = 0; j<= cantidadDatos; j++){
           ArtifactList.add(new RecyclerViewModel(R.drawable.circle,R.drawable.circle,consultaregistro[j][2],consultaregistro[j][2]));
       }
    }*/
}