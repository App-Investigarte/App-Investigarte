package com.app_investigarte.ListadoArtefactos;

public class RecyclerViewModel

{
    private int id;
    private String imageView1;
    private String texview1;

    // Se creo un molde o clase que contenga la estructura que tendría cada carview
    // y en base a esta poder crear varios objetos que contendrían la información de cada artefacto.
    public RecyclerViewModel(int id,String imageView1, String texview1) {
        this.id = id;
        this.imageView1=imageView1;
        this.texview1 = texview1;
    }

    public int getId(){return id;}

    public String getImageView1()
    {
        return imageView1;
    }

    public String getTexview1() {
        return texview1;
    }

    public void setImageView1(String imageView1) {
        this.imageView1 = imageView1;
    }

    public void setTexview1(String texview1) {
        this.texview1 = texview1;
    }

}
