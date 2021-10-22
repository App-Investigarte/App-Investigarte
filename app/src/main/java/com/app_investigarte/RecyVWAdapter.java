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
        int imagen2=ArtifactList.get(position).getImageView2();
        String name=ArtifactList.get(position).getTexview1();
        String name2=ArtifactList.get(position).getTexview2();

        holder.setData(imagen,imagen2,name,name2);
    }

    @Override
    public int getItemCount()
    {
        return ArtifactList.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder
    {
        private ImageView imageView1;
        private ImageView imageView2;
        private TextView textView;
        private TextView textView2;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            imageView1=itemView.findViewById(R.id.artifact1_imagvw);
            imageView2=itemView.findViewById(R.id.artifact2_imagvw);
            textView=itemView.findViewById(R.id.artifact1_txtvw);
            textView2=itemView.findViewById(R.id.artifact2_txtvw);

        }


        public void setData(int imagen, int imagen2, String name, String name2)
        {
            imageView1.setImageResource(imagen);
            imageView2.setImageResource(imagen2);
            textView.setText(name);
            textView2.setText(name2);
        }
    }
}
