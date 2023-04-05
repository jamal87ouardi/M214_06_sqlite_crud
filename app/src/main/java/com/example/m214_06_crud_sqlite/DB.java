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
        super(context, "DB_Hotel", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String req = "CREATE TABLE Hotel (ID INTEGER PRIMARY KEY AUTOINCREMENT,Nom TEXT ,Prix float, Url text)";
        db.execSQL(req);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS Hotel");

        onCreate(db);

    }

    public boolean search(int ID) {

        List<Hotel> hotels = get_All();
        boolean exist = false;
        for(Hotel h : hotels) {

            if(h.getID()==ID) exist=true;

        }
        return exist;
    }

    public long add_Hotel(Hotel m) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();



        values.put("Nom", m.getNom());

        values.put("Prix",m.getPrix());

        values.put("Url",m.getUrl());


        long r = db.insert("Hotel", null, values);


        db.close();

        return r;

    }


    public long updateHotel(int ID,String nom, float prix, String img) {


        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();



        values.put("Nom", nom);

        values.put("Prix",prix);

        values.put("Url",img);


        long r = db.update("Hotel", values, "ID=?", new String[]{String.valueOf(ID)});


        db.close();

        return r;



    }

    public long deleteHotel(int ID) {


        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();


        long r = db.delete("Hotel", "ID=?", new String[]{String.valueOf(ID)});


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
                h.setID(cur.getInt(0));
                h.setNom(cur.getString(1));
                h.setPrix(cur.getFloat(2));
                h.setUrl(cur.getString(3));

                hotels.add(h);
            } while (cur.moveToNext());
        }

        return hotels;
    }



}
