package com.example.le9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.le9.model.Reservation;

public class listeReservationAdmin extends AppCompatActivity {
ListView list;
ArrayAdapter<Reservation> aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_reservation_admin);

        Asynchrone asynchrone = new Asynchrone(this, "getAll");
        String url = "http://10.0.2.2/webservices/le9.php/";
        String[] chaine = {url};
        asynchrone.execute(chaine);



    }
}