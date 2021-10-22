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
        int imagen=ArtifactList.get(position).getImageView1();
        String name=ArtifactList.get(position).getTexview1();

       holder.startDescription(holder.itemView);
        holder.setData(imagen,name);
    }

    @Override
    public int getItemCount()
    {
        return ArtifactList.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder
    {
        private ImageView imageView1;
        private TextView textView;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            imageView1=itemView.findViewById(R.id.artifact1_imagvw);
            textView=itemView.findViewById(R.id.artifact1_txtvw);
        }


        public void startDescription(View view){

            view.setOnClickListener( v -> {
                Toast.makeText(view.getContext(),"id" + textView.getText(),Toast.LENGTH_SHORT).show();
                intent=new Intent(view.getContext(),NavDrawerActivity.class);
                view.getContext().startActivity(intent);
            });

        }

        public void setData(int imagen, String name)
        {
            imageView1.setImageResource(imagen);
            textView.setText(name);
        }
    }
}
