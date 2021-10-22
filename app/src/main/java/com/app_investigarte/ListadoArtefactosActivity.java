package com.app_investigarte;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.app_investigarte.database.DatabaseAccess;

import java.util.ArrayList;
import java.util.List;

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
        int subregion = parametros.getInt("subregion");
        initData(subregion);
        initRecyclerView();
    }



    private void initData(int subregion)
    {
        ArtifactList=new ArrayList<>();
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();
        int cantidadDatos = databaseAccess.CantidadArtefactosSubR(subregion);
        String [][]consultaregistro = databaseAccess.getArtifactSubregion(subregion, cantidadDatos);
        databaseAccess.close();

        for(int i = 0; i < cantidadDatos; i++){
                ArtifactList.add(new RecyclerViewModel(R.drawable.circle,  consultaregistro[i][1]));
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