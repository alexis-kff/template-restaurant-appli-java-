package com.example.le9;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;

import com.example.le9.model.Reservation;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Asynchrone extends AsyncTask<Object, Integer, String> {
    private Activity activity;
    private String action;

    public Asynchrone(Activity activity, String action){
        this.activity = activity;
        this.action = action;
    }
    //Dans la méthode doInBackground on va appeler les opérations CRUD sur le WS
    @Override
    protected String doInBackground(Object... strings) {
        String result = "";
        if(action.equals("create")){
            try {
                result=Dao.create((String) strings[0], (Reservation) strings[1]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(action.equals("delete")){
            try {
                result=Dao.delete((String) strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(action.equals("getAll")){
            try {
                result=Dao.getAll((String) strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    //result: est le résultat de doInBackground
    @Override
    protected void onPostExecute(String result) {
        // TODO Auto-generated method stub
        super.onPostExecute(result);

        Log.d("resultat", result);

        if (action.equals("create")) {

           Intent intent = new Intent(activity.getApplication(), Base.class);
            intent.setAction("createRes");
            activity.startActivity(intent);
        }

        if (action.equals("getAll")){
            Log.d("res", result);
            ObjectMapper mapper = new ObjectMapper();
            Log.d("res", "result");
            try {
               Log.d("res", "result");
                Reservation[] listReservation = mapper.readValue(result, Reservation[].class);
              //  List<Reservation> liste = listReservation;
               Log.d("res", listReservation.toString());
                ListView listView = activity.findViewById(R.id.elist_res);
                Log.d("res", listReservation.toString());
                AndroidAdapter aa;
               aa = new AndroidAdapter(activity, R.layout.row_list_res, listReservation);
             //  ArrayAdapter aa;
             //   aa = new ArrayAdapter(activity,android.R.layout.simple_list_item_1,listReservation);
                Log.d("res", listReservation.toString());
                listView.setAdapter(aa);
                for (Reservation reservation: listReservation){
                    Log.d("liste",reservation.toString());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
