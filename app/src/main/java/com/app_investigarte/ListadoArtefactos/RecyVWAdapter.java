package com.app_investigarte.ListadoArtefactos;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.app_investigarte.DescripcionActivity;
import com.app_investigarte.R;

import java.util.List;

public class RecyVWAdapter extends RecyclerView.Adapter<RecyVWAdapter.ViewHolder>
{
    // Se Creo una lista con la forma o molde del RecyclerViewModel
    private final List<RecyclerViewModel> ARTIFACTLIST;
    Intent intent;

    //Se Crea el constructor de la clase que recibe como parámetros una lista con todos los artefactos
    //de esta clase se crea un objeto en la clase de ListadoArtefactos en la linea 105
    public RecyVWAdapter(List<RecyclerViewModel> ARTIFACTLIST)
    {
        this.ARTIFACTLIST = ARTIFACTLIST;
    }

    @NonNull
    @Override
    public RecyVWAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        // le asignamos en una vista el cardView que vamos a utilizar para mostrar el listado de artefactos
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardsview_artifacts,parent,false);

        // Retornamos un objeto del ViewHolder Creado con la vista del cardView
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyVWAdapter.ViewHolder holder, int position)
    {
        int id = ARTIFACTLIST.get(position).getId();
        String imagen= ARTIFACTLIST.get(position).getImageView1();
        String name= ARTIFACTLIST.get(position).getTexview1();

        //se Le pasa o asigna la información de cada artefacto a su correspondiente CardView
        holder.setData(id,imagen,name);
    }

    //cuenta la cantidad o tamaño de la lista de artefactos
    @Override
    public int getItemCount()
    {
        return ARTIFACTLIST.size();
    }


    //Se Creo una clase llamada ViewHolder
    public class ViewHolder extends  RecyclerView.ViewHolder
    {
        //se crearon las variables o parámetros que tendría el card View
        //Tales como Id,Imagen,y el Nombre dee artefacto
        private int id;
        private final ImageView IMAGEVIEW1;
        private final TextView TEXTVIEW;

        //se Crea el Constructor de la clase que recibe como parámetro una vista que seria el CardView
        public ViewHolder(@NonNull View itemView)
        {
            //se le pasar la vista
            super(itemView);

            // se hace referencia con los id de cada elemento para la imagen y el texto
            IMAGEVIEW1 =itemView.findViewById(R.id.artifact1_imagvw);
            TEXTVIEW =itemView.findViewById(R.id.artifact1_txtvw);

            //Si se da click en el artefacto pasamos a la siguiente activity de descripción
            startDescription(itemView);
        }

        //ejecuta la activity de la descripción de cada artefacto
        public void startDescription(View view){
            //Se controla el evento de click en la vista en este caso el CardView
            view.setOnClickListener( v -> {
                intent=new Intent(view.getContext(), DescripcionActivity.class);
                intent.putExtra("id",id);
                view.getContext().startActivity(intent);
            });
        }

        //Se le pasan los datos con los que queremos llenar cada carView o artefacto
        public void setData(int id, String imagen, String name)
        {
            //se le asigna el id del Artefacto
            this.id = id;

            //se le asigna la imagen del artefacto al CardView
            if(imagen.equals("image")){
                IMAGEVIEW1.setImageResource(R.drawable.ic_sombrero);
                IMAGEVIEW1.setColorFilter(R.color.Color_darck);
                IMAGEVIEW1.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            }

            //se asigna el texto del artefacto al CardView
            TEXTVIEW.setText(name);
        }
    }
}
