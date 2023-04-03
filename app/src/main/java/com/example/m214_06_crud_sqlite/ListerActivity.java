package com.example.m214_06_crud_sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;



public class ListerActivity extends AppCompatActivity {

    private List<Hotel> hotels;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = findViewById(R.id.lv);
        DB db = new DB(getApplicationContext());

        hotels = db.get_All();

        Adapter ma = new Adapter(hotels,getApplicationContext(),R.layout.item);

        listView.setAdapter(ma);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Hotel selected_hotel=hotels.get(position);

                Intent i = new Intent(getApplicationContext(), UpdateDelete.class);

                i.putExtra("nom",selected_hotel.getNom());
                i.putExtra("prix",String.valueOf(selected_hotel.getPrix()));
                i.putExtra("url",selected_hotel.getUrl());

                startActivity(i);

            }
        });

    }
}