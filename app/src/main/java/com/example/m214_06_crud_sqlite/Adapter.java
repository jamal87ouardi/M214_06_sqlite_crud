package com.example.m214_06_crud_sqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends BaseAdapter {

    private List<Hotel> listHotel;
    private Context mContext;
    private int layoutID;

    public Adapter(List<Hotel> listHotel, Context mContext, int layoutID) {
        this.listHotel = listHotel;
        this.mContext = mContext;
        this.layoutID = layoutID;
    }

    @Override
    public int getCount() {
        return listHotel.size();
    }

    @Override
    public Object getItem(int position) {
        return listHotel.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder=new ViewHolder();
        LayoutInflater layoutInflater = (LayoutInflater)   mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = layoutInflater.inflate(layoutID,null);

        viewHolder.Nom = convertView.findViewById(R.id.textView);
        viewHolder.Url = convertView.findViewById(R.id.imageView);

        Hotel m = listHotel.get(position);

        viewHolder.Nom.setText(m.getNom());

        Picasso.get().load(m.getUrl()).into(viewHolder.Url);

        return convertView;


    }


    private class ViewHolder {

        TextView Nom;
        TextView Prix;
        ImageView Url;
    }
}
