package com.app_investigarte;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyVWAdapter extends RecyclerView.Adapter<RecyVWAdapter.ViewHolder>
{
    private List<RecyclerViewModel> ArtifactList;
    Intent intent;

    public RecyVWAdapter(List<RecyclerViewModel>ArtifactList)
    {
        this.ArtifactList=ArtifactList;
    }

    @NonNull
    @Override
    public RecyVWAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardsview_artifacts,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyVWAdapter.ViewHolder holder, int position)
    {
        int id = ArtifactList.get(position).getId();
        String imagen=ArtifactList.get(position).getImageView1();
        String name=ArtifactList.get(position).getTexview1();

        holder.setData(id,imagen,name);
    }

    @Override
    public int getItemCount()
    {
        return ArtifactList.size();
    }


    public class ViewHolder extends  RecyclerView.ViewHolder
    {
        private int id;
        private ImageView imageView1;
        private TextView textView;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            imageView1=itemView.findViewById(R.id.artifact1_imagvw);
            textView=itemView.findViewById(R.id.artifact1_txtvw);
            startDescription(itemView);
        }

        //ejecuta la activity de la Decripcion de cada artefacto
        public void startDescription(View view){
            view.setOnClickListener( v -> {
                intent=new Intent(view.getContext(),DescripcionActivity.class);
                intent.putExtra("id",id);
                view.getContext().startActivity(intent);
            });
        }

        //Se le pasan los datos con los que queremos llenar cada carView o artefacto
        public void setData(int id, String imagen, String name)
        {
            this.id = id;
            imageView1.setImageDrawable(null);
            textView.setText(name);
        }
    }
}
