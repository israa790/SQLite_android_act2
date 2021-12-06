package com.example.tp6_android_exercice_1v2;


import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText id, name, qt;
    TextView texte;
    ProductDAO DAO;
    Cursor c;
    DataBaseHandler DatabaseHandler;
    Integer qtt,id1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id = (EditText) findViewById(R.id.id);
        name = (EditText) findViewById(R.id.name);
        qt = (EditText) findViewById(R.id.qte);
        texte = findViewById(R.id.txt);
        DAO = new ProductDAO(this);

    }

    public void add(View view) {
        qtt = Integer.parseInt(qt.getText().toString());
        id1 =Integer.parseInt(id.getText().toString());
        Product p = new Product(id1, name.getText().toString(), qtt);
        DAO.insertdata(p);
    }

    public void delete(View view) {
        DAO.deletedata(id1);
    }

    public void show(View view) {
        c = DAO.showdata();
        texte.setText("");
        if (c.getCount() == 0) {
            Toast.makeText(getApplicationContext(),"table vide",Toast.LENGTH_SHORT).show();
        } else {
            while (c.moveToNext()) {
                texte.append(c.getString(1));
                texte.append("\n");
            }

        }
    }
}
