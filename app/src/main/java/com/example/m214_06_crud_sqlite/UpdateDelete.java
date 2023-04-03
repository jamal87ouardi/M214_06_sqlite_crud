package com.example.m214_06_crud_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class UpdateDelete extends AppCompatActivity {
    EditText nom,prix,url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);

        nom=findViewById(R.id.ed_nom_edit);
        prix=findViewById(R.id.ed_prix_edit);
        url=findViewById(R.id.ed_url_edit);


        Bundle extras = getIntent().getExtras();

        nom.setText(extras.getString("nom"));
        prix.setText(extras.getString("prix"));
        url.setText(extras.getString("url"));


    }
}