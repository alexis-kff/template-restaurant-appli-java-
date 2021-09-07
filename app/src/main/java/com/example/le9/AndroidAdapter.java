package com.example.le9;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.le9.model.Reservation;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class AndroidAdapter extends ArrayAdapter<Reservation> {
    private Context context;
    private int resource;
    private Reservation[] listResa;
    private LayoutInflater layoutInflater;


    public AndroidAdapter(@NonNull Context context, int resource, @NonNull Reservation[] objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.listResa = objects;
        // On initialise le layoutInflater au niveau du constructeur pour éviter de le faire plusieurs fois
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       // super.getView(position, convertView, parent);
        if (convertView == null) {

            convertView = layoutInflater.inflate(R.layout.row_list_res, parent, false);
        }

        TextView nom = convertView.findViewById(R.id.lnom);
        TextView date = convertView.findViewById(R.id.ldate);
        TextView heure = convertView.findViewById(R.id.lheure);
        TextView nbr = convertView.findViewById(R.id.lnbr_pers);
        TextView coment = convertView.findViewById(R.id.lcoment);
        TextView comfirm = convertView.findViewById(R.id.lcomfirm);
        ImageView imageView = convertView.findViewById(R.id.imageView);
        ImageView imageView2 = convertView.findViewById(R.id.imageView2);
        
        nom.setText(listResa[position].getName());
        date.setText(listResa[position].getDay_res());
        heure.setText(listResa[position].getHour_res());
        nbr.setText(listResa[position].getNbr_pers());
        coment.setText(listResa[position].getComent());
        comfirm.setText(listResa[position].getComfirm());


        return convertView;
    }
}
