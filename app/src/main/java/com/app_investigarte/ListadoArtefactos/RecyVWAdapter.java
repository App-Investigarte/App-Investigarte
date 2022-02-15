package com.app_investigarte.ListadoArtefactos;

import static com.app_investigarte.ListadoArtefactos.ConvertirIMGBase64.convertirAimagen;

import android.content.Intent;
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
                intent=new Intent(view.getContext(), DescripcionActivity.class);
                intent.putExtra("id",id);
                view.getContext().startActivity(intent);
            });
        }

        //Se le pasan los datos con los que queremos llenar cada carView o artefacto
        public void setData(int id, String imagen, String name)
        {
            this.id = id;
            if(imagen == null){
                imageView1.setImageBitmap(null);
            }else{
                imageView1.setImageBitmap (ConvertirIMGBase64.convertirAimagen(imagen));
                imageView1.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            textView.setText(name);
        }
    }
}
