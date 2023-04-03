package com.example.m214_06_crud_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DB extends SQLiteOpenHelper {
    public DB(@Nullable Context context) {
        super(context, "DB_Hotel", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String req = "CREATE TABLE Hotel (Nom TEXT Primary key,Prix float, Url text)";
        db.execSQL(req);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS Hotel");

        onCreate(db);

    }

    public long add_Hotel(Hotel m) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();


        values.put("Nom", m.getNom());

        values.put("Prix",m.getPrix());

        values.put("Url",m.getUrl());

        // Inserting Row
        long r = db.insert("Hotel", null, values);

        // Closing database connection
        db.close();

        return r;

    }


    public List<Hotel> get_All() {

        SQLiteDatabase db = this.getWritableDatabase();

        List<Hotel> hotels = new ArrayList<>();

        Cursor cur = db.rawQuery("SELECT * FROM Hotel",null);
        if(cur.moveToFirst()) {
            do {
                Hotel h = new Hotel();

                h.setNom(cur.getString(0));
                h.setPrix(cur.getFloat(1));
                h.setUrl(cur.getString(2));

                hotels.add(h);
            } while (cur.moveToNext());
        }

        return hotels;
    }



}
