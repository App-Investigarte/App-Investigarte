package com.app_investigarte;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyVWAdapter extends RecyclerView.Adapter<RecyVWAdapter.ViewHolder>
{
    private List<RecyclerViewModel> ArtifactList;

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


        public void setData(int imagen, String name)
        {
            imageView1.setImageResource(imagen);
            textView.setText(name);
        }
    }
}
