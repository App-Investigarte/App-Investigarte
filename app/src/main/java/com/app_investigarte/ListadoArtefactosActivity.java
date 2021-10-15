package com.app_investigarte;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.app_investigarte.database.DatabaseAccess;

import java.util.ArrayList;
import java.util.List;

public class ListadoArtefactosActivity extends AppCompatActivity

{

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    ArrayList<RecyclerViewModel>ArtifactList;
    RecyVWAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_artefactos);

        initData();
        initRecyclerView();
    }



    private void initData()
    {
        ArtifactList=new ArrayList<>();
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();
        int cantidadDatos = databaseAccess.CantidadArtefactosSubR(8);
        String [][]consultaregistro = databaseAccess.getArtifactSubregion(8, cantidadDatos);
        databaseAccess.close();

        for(int i = 0; i < cantidadDatos-1; i=i+2){
           // if(i==cantidadDatos-1){
           //     break;
          //  }else{
                ArtifactList.add(new RecyclerViewModel(R.drawable.circle, R.drawable.circle, consultaregistro[i][1], consultaregistro[1 + i][1]));
           // }
        }
    }

    private void initRecyclerView()
    {
        recyclerView=findViewById(R.id.artefactos_recycleryview);
        layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
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