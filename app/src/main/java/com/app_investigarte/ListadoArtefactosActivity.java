package com.app_investigarte;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ListadoArtefactosActivity extends AppCompatActivity

{

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<RecyclerViewModel>ArtifactList;
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
        ArtifactList.add(new RecyclerViewModel(R.drawable.circle,R.drawable.circle,"Nombre","Nombre"));
        ArtifactList.add(new RecyclerViewModel(R.drawable.circle,R.drawable.circle,"Nombre","Nombre"));
        ArtifactList.add(new RecyclerViewModel(R.drawable.circle,R.drawable.circle,"Nombre","Nombre"));

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
}