package com.example.tp6_android_exerceice2;


import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText id, Fname,Lname;
    RadioButton TI,DSI,RSI;
    String Classe;
    TextView texte;
    EtudiantDAO DAO;
    Cursor c;
    DataBaseHandler DatabaseHandler;
    Integer txt,id1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id = (EditText) findViewById(R.id.id);
        Fname = (EditText) findViewById(R.id.prenom);
        Lname = (EditText) findViewById(R.id.nom);
        TI=findViewById(R.id.radio1);
        DSI=findViewById(R.id.radio2);
        RSI=findViewById(R.id.radio3);
        if(TI.isChecked())
        {
            Classe=TI.getText().toString();
        }
        else if(DSI.isChecked())
        {
            Classe=DSI.getText().toString();
        }
        else{
            Classe=RSI.getText().toString();
        }

        texte = findViewById(R.id.edit);
        DAO = new EtudiantDAO(this);

    }

    public void add_student(View view) {

        id1 =Integer.parseInt(id.getText().toString());

        Etudiant e = new Etudiant(id1, Fname.getText().toString(), Lname.getText().toString(),Classe);
        DAO.insertdata(e);
    }

    public void delete_student(View view) {
        DAO.deletedata(id1);
    }

    public void show_all(View view) {
        c = DAO.showdata();
        texte.setText("");
        if (c.getCount() == 0) {
            Toast.makeText(getApplicationContext(),"table vide",Toast.LENGTH_SHORT).show();
        } else {
            while (c.moveToNext()) {

                texte.append(" _FirstName: ");
                texte.append(c.getString(2));texte.append("\n");
                texte.append(" _LastName: ");
                texte.append(c.getString(1));texte.append("\n");
                texte.append(" _Class: ");
                texte.append(c.getString(3));texte.append("\n");
                texte.append("----------------");
                texte.append("\n");
            }

        }
    }
    public void modify_student(View view) {
     //   txt =Integer.parseInt(texte.getText().toString());
        id1 =Integer.parseInt(id.getText().toString());
        Etudiant e = new Etudiant(Fname.getText().toString(), Lname.getText().toString(),Classe);
        DAO.updatedata(e,id1);

    }

    public void search_student(View view) {
      //  txt =Integer.parseInt(texte.getText().toString());
        id1 =Integer.parseInt(id.getText().toString());
        c = DAO.searchdata(id1);
        texte.setText("");
        if (c.getCount() == 0) {
            Toast.makeText(getApplicationContext(),"table vide",Toast.LENGTH_SHORT).show();
        } else {
            while (c.moveToNext()) {
                texte.append(" _FirstName: ");
                texte.append(c.getString(2));texte.append("\n");
                texte.append(" _LastName: ");
                texte.append(c.getString(1));texte.append("\n");
                texte.append(" _Class: ");
                texte.append(c.getString(3));texte.append("\n");
                texte.append("----------------");
                texte.append("\n");
            }

        }
    }



}
