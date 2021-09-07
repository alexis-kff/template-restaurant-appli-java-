package com.example.le9;

import com.example.le9.model.Reservation;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Dao {
    //On cree un objet de type OkHttpClient
    static OkHttpClient client = new OkHttpClient();
    //On cree un JSONArray pour stocker des objets de json
    JSONArray jarray;
    //On définit le type de contenu
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    //on créer la méthode create avec comme paramètre l'url et un objet de type Book
    static String create(String url, Reservation reservation) throws IOException {
        //On créer un objet (librairie Jackson) pour la conversion objet <=> Json
        ObjectMapper mapper = new ObjectMapper();
        //On converti l'objet en chaine Json
        String chainejson = mapper.writeValueAsString(reservation);
        //On créer la requete on lui passe la chaine Json et l'url et le verbe http
        RequestBody body = RequestBody.create(JSON, chainejson);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        //On execute la requête et on renvoie la réponse
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    //Get
    static String getAll(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
    //Delete
    static String delete(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .delete()
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
