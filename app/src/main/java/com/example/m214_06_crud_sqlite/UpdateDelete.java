package com.example.m214_06_crud_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateDelete extends AppCompatActivity {
    EditText nom,prix,url;
    Button update,delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);

        nom=findViewById(R.id.ed_nom_edit);
        prix=findViewById(R.id.ed_prix_edit);
        url=findViewById(R.id.ed_url_edit);
        update = findViewById(R.id.button_edit);
        delete=findViewById(R.id.button2_edit);


        Bundle extras = getIntent().getExtras();

        int ID = extras.getInt("ID");

        nom.setText(extras.getString("nom"));
        prix.setText(extras.getString("prix"));
        url.setText(extras.getString("url"));

        DB db = new DB(getApplicationContext());

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                long r=db.updateHotel(ID,nom.getText().toString(), Float.parseFloat(prix.getText().toString()),url.getText().toString());
                if (r != -1) {
                    Toast.makeText(getApplicationContext(), "Hotel Modifié avec succée", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Echec", Toast.LENGTH_LONG).show();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                long r=db.deleteHotel(ID);
                if (r != -1) {
                    Toast.makeText(getApplicationContext(), "Hotel Supprimé avec succée", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Echec", Toast.LENGTH_LONG).show();
                }

            }
        });



    }
}