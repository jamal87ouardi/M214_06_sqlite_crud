package com.example.m214_06_crud_sqlite;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;



public class ListerActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = findViewById(R.id.lv);
        DB db = new DB(getApplicationContext());

        List<Hotel> hotels = db.get_All();

        Adapter ma = new Adapter(hotels,getApplicationContext(),R.layout.item);

        listView.setAdapter(ma);

    }
}