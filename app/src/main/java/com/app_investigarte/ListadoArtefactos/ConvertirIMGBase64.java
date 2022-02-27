package com.app_investigarte.ListadoArtefactos;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;


//Como la arquitectura de la aplicación sera diferente esta clase se Borrar de no utilizarse nunca.
public class ConvertirIMGBase64 {

    public static Bitmap convertirAimagen(String imgbase64String){
        String base64Image = imgbase64String.split(",")[1];
        byte[] decodedString = Base64.decode(base64Image, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
    }
}
