package com.g2.androidapp.lotsoflots;

import android.app.VoiceInteractor;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class APIRetrieveSystem {
    //public static final DateTimeFormatter ISO_INSTANT;

    APIRetrieveSystem(){ //constructor

    }

    static void retrieveCarParks(Context context){
        String URL = "https://data.gov.sg/api/action/datastore_search?resource_id=139a3035-e624-4f56-b63f-89ae28d4ae4c&";
        //create a request queue
        RequestQueue requestQueue=Volley.newRequestQueue(context);

        //create json request
        JsonObjectRequest objectRequest = new JsonObjectRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try{
                            JSONArray jsonArray = response.getJSONArray("carpark_data");
                            for(int i = 0; i < jsonArray.length(); i++){
                                //Carpark carpark_data.getInt("car_park_no") = new Carpark();
                            }
                        } catch (JSONException e){
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }
        );

        requestQueue.add(objectRequest);

    }

    void retrieveVacancies(Context context){
        String timeStamp = Instant.now().toString();
        retrieveVacancies(timeStamp, context);

    }

    static void retrieveVacancies(String date_time, Context context){

        String URL = "https://api.data.gov.sg/v1/transport/carpark-availability?date_time=";
        String ReqURL = URL + date_time;

        //create a request queue
        RequestQueue requestQueue=Volley.newRequestQueue(context);

        //create json request
        JsonObjectRequest objectRequest = new JsonObjectRequest(
                Request.Method.GET,
                ReqURL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try{
                            JSONArray jsonArray = response.getJSONArray("carpark_data");
                            for(int i = 0; i < jsonArray.length(); i++){
                                //Carpark carpark_data.getInt("carpark_number") = new Carpark(); //should implement a search for the same carpark no
                                //carpark_data.getInt("carpark_number").vacancies = carpark_data.getInt("lots_available");
                                //CarparkList.Carparks[i] = carpark_data.getInt("carpark_number");
                            }
                        } catch (JSONException e){
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }
                );

        requestQueue.add(objectRequest);

    }
}
