package com.app_investigarte;

public class RecyclerViewModel

{
    private int imageView1;
    private String texview1;


    public RecyclerViewModel(int imageView1, String texview1) {
        this.imageView1=imageView1;
        this.texview1 = texview1;
    }

    public int getImageView1()
    {
        return imageView1;
    }

    public String getTexview1() {
        return texview1;
    }

    public void setImageView1(int imageView1) {
        this.imageView1 = imageView1;
    }

    public void setTexview1(String texview1) {
        this.texview1 = texview1;
    }

}
