package com.example.tp6_android_exerceice2;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class EtudiantDAO {
    public static final String CREATE_TABLE = "create table etudiant ( id INTEGER PRIMARY KEY, Firstname TEXT, Lastname TEXT, Classe TEXT);" ;
    public static final String DROP_TABLE="DROP TABLE IF EXISTS etudiant ";
    public DataBaseHandler dbHandler;
    //Constructor
    public EtudiantDAO(Context context) {
        dbHandler = new DataBaseHandler(context,"", null,1);
    }
    public void insertdata (Etudiant p)  {
        SQLiteDatabase db = dbHandler.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("id" , p.getId());  values.put("FirstName", p.getFirstname());values.put("LastName",p.getLastname());
        values.put("Classe", p.getClasse());
        // Insertion Ligne (Row)
        db.insert("etudiant", null, values);
        db.close();
        // fermer la connection BD
    }
    public void deletedata(Integer first){
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        db.delete("etudiant","id='"+first+"'",null);
    }
    public Cursor showdata(){
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        String req="SELECT * FROM etudiant";
        Cursor c=db.rawQuery(req,null);   return c;
    }
    public Cursor searchdata(Integer second){
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        String req="SELECT * FROM etudiant WHERE id='"+second+"'";
        Cursor c=db.rawQuery(req,null);   return c;
    }
    public void updatedata (Etudiant p, Integer third)  {
        SQLiteDatabase db = dbHandler.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("FirstName", p.getFirstname());values.put("LastName",p.getLastname());
        values.put("Classe", p.getClasse());
        // Insertion Ligne (Row)
        db.update("etudiant", values,"id='"+third+"'",null);
        db.close();
        // fermer la connection BD
    }


}
