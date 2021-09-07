package com.example.le9;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.le9.model.Reservation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;




public class Reservation_frag extends Fragment {

    EditText enom,ephone,eday_res,ecomment,enbrpers;
    ArrayAdapter<String>aa;
    Spinner ehour;
    Button boutton ,bliste;
    String[] heure = {"12h","12h30","13h","13h30","14h"};

    public Reservation_frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_reservation_frag, container, false);

        enom = v.findViewById(R.id.ename);
        ephone = v.findViewById(R.id.ephone);
        eday_res = v.findViewById(R.id.edayres);
        ehour = v.findViewById(R.id.spinner);
        enbrpers = v.findViewById(R.id.enbrpers);
        ecomment = v.findViewById(R.id.ecoment);
        boutton = v.findViewById(R.id.boutton);
        bliste = v.findViewById(R.id.button3);

       aa = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,heure);
       ehour.setAdapter(aa);


        boutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = enom.getText().toString();
                String day_res = eday_res.getText().toString();
                String phone = ephone.getText().toString();
                String hour_res = ehour.getSelectedItem().toString();
                String nbr_pers = enbrpers.getText().toString();
                String coment = ecomment.getText().toString();
                String comfirm = "non-comfirmée";

                DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date date = new Date();
                String date_res = format.format(date);
                Log.d("result", date_res);

                Asynchrone asynchrone = new Asynchrone(getActivity(),"create");
                Reservation reservation = new Reservation(name,day_res,hour_res,phone,nbr_pers,coment,date_res,1,comfirm);
                Object[] objet = {"http://10.0.2.2/webservices/le9.php/", reservation};
                asynchrone.execute(objet);

            }
        });
        bliste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getActivity(),listeReservationAdmin.class);
                startActivity(it);
            }
        });


        return v;
    }



}