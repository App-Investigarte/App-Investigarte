package com.app_investigarte;

public class RecyclerViewModel

{
    private int imageView1;
    private int imageView2;
    private String texview1;
    private String texview2;




    public RecyclerViewModel(int imageView1, int imageView2, String texview1, String texview2) {

        this.imageView1=imageView1;
        this.imageView2=imageView2;
        this.texview1 = texview1;
        this.texview2 = texview2;

    }

    public int getImageView1()
    {
        return imageView1;
    }

    public int getImageView2() {
        return imageView2;
    }


    public String getTexview1() {
        return texview1;
    }

    public String getTexview2() {
        return texview2;
    }


}
