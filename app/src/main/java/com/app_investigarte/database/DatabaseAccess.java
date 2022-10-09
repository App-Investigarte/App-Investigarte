package com.app_investigarte.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;
    //***********************************************************************************************//
    //Autor: John Esteban Alvarez Piedrahita
    //Implementamos el Patrón Singleton
    //Para garantiza la existencia de una única instancia para la clase de la DatabaseAccess
    //ya que solo queremos tener una sola instancia y no muchas instancias de la base de datos

    //con getInstance retornamos una instancia unica del objeto
    public static DatabaseAccess getInstance(Context context) {
        //verificamos si la instancia es nula
        //si la instancia es nula significa que no se a instanciado aun el objeto y lo tenemos que crear
        if (instance == null) {
            //Creamos la instancia del objeto
            instance = new DatabaseAccess(context);
        }
        return instance;
    }
    //Se Crea un constructor privado para evitar la creación de objetos desde fuera de la clase
     private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
     }
    //***********************************************************************************************//
    //to open the database
    public void open() {
        this.db = openHelper.getWritableDatabase();
    }

    //closing the database connection
    public void close() {
        if (db != null) {
            this.db.close();
        }
    }


    //consultar cunatos artefactoy hay en total
    public int cantidadAllArtefactos() {
        c = db.rawQuery("select COUNT(*) FROM Artifact a", null);
        int cantidad = 0;
        while (c.moveToNext()) {
            cantidad = c.getInt(0);
        }
        return cantidad;
    }

    //Consulta Listado de todos los artefactos
    public String[][] getAllArtifact(int cantidaRegistros) {
        c = db.rawQuery("select a.id, a.name, a.image, a.id_municipality, m.name, m.id_subregions FROM Artifact a inner join Municipality m on a.id_municipality = m.id",null);
        int columnas=6;
        String arr[][] = new String[cantidaRegistros][columnas];

        for (int i = 0; i < columnas; i++) {
            c.moveToFirst();
            for (int j = 0; j < cantidaRegistros; j++) {
                arr[j][i] = c.getString(i);
                c.moveToNext();
            }
        }
        return arr;
    }

    public int CantidadArtefactosSubR(int subregion) {
        c = db.rawQuery("select COUNT(*) FROM Artifact a inner join Municipality m on a.id_municipality = m.id WHERE m.id_subregions = "+subregion +";", null);

        int cantidad = 0;
        while (c.moveToNext()) {
            cantidad = c.getInt(0);
        }
        return cantidad;
    }



    //Consulta Listado de artefactos
    public String[][] getArtifactSubregion(int subregion, int cantidaRegistros) {
        c = db.rawQuery("select a.id, a.name, a.image, a.id_municipality, m.name, m.id_subregions FROM Artifact a inner join Municipality m on a.id_municipality = m.id WHERE m.id_subregions = "+subregion +";",null);
        int columnas=6;
        String arr[][] = new String[cantidaRegistros][columnas];

        for (int i = 0; i < columnas; i++) {
            c.moveToFirst();
            for (int j = 0; j < cantidaRegistros; j++) {
                arr[j][i] = c.getString(i);
                c.moveToNext();
            }
        }
        return arr;
    }


    //consulta informacion Artefacto
    public String[] getDescription(int id) {

        c = db.rawQuery("SELECT a.id, a.name, a.image, a.description, m.name, s.name, d.name, s.id, c.name, ac.name, cc.name, pc.name, a.materials "+
        "FROM Artifact a "+
        "INNER JOIN Municipality m on a.id_municipality = m.id "+
        "INNER JOIN Subregions s  on m.id_subregions = s.id " +
        "INNER JOIN Department d on s.id_department = d.id " +
        "INNER JOIN Community c on a.id_community = c.id " +
        "INNER JOIN Artisan_classification ac on a.id_artisan_classification  = ac.id " +
        "INNER JOIN Clothing_category cc on a.id_clothing_category  = cc.id " +
        "INNER JOIN Patrimonial_category pc on a.id_patrimonial_category  = pc.id " +
        "WHERE a.id =  "+id+";",null);

        int columnas=13;

        String informacion[]= new String[columnas];

        for (int i = 0; i < columnas; i++) {
            c.moveToFirst();
            informacion[i] = c.getString(i);
            //c.moveToNext();
        }
        return informacion;
    }


    public String[] getUserCorreoExiste(String email){
        //c = db.rawQuery("select count(*) , name from Users where  email= 'esteban.ea145@gmail.com'",null);

        c = db.rawQuery("select count(*) , name from Users where  email= '"+email+"'",null);
        String[] informacion = new String[2];
        for (int i = 0; i < 2; i++) {
            c.moveToFirst();
            informacion[i] = c.getString(i);
        }
        return informacion;
    }

    public int getUserExistencia(long id){
        c = db.rawQuery("select count(*) from Users where  id="+id,null);
        int cantidad = 0;
        while (c.moveToNext()){
            cantidad = c.getInt(0);
        }
        return cantidad;
    }


    public void addUser(String id, String email, String name, String phone_number, String date_user){
        //INSERT INTO Users  (id, password , email , name  , phone_number, image, date_user) values (1017272663, 12345678 , "esteban.ea145@gmail.com", "John Esteban", 3215801523, null, "25/06/1999");
     //   c = db.rawQuery("INSERT INTO Users  (id, email , name  , phone_number, image, date_user) values (1017272661, 'esteban.ea145@gmail.com', 'John Esteban', 3215801523, null, '25/06/1999');",new String[]{});
        db.execSQL("INSERT INTO Users  (id, email , name  , phone_number, image, date_user)" +
                "VALUES(" + id + ", '" + email + "', '" + name + "', " + phone_number + ", null , '" + date_user +"');");
    }

}
