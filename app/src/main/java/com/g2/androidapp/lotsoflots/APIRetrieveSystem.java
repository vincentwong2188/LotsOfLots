package com.g2.androidapp.lotsoflots;

import android.app.VoiceInteractor;
import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.Instant;
import java.util.Date;

public class APIRetrieveSystem {


    public static String teststring;


    APIRetrieveSystem(){ //constructor

    }

    static void retrieveall(Context context){
        String timeStamp = Instant.now().toString();
        Log.d("Response", "timestamp is: " + timeStamp.substring(0, 19));
        retrieveall(timeStamp.substring(0, 19), context);

    }

    static void retrieveall(String date_time, Context context){


        //first we fill the carpark list array with carpark objects (with no vacancies yet)
        retrieveCarParks(context);
        Log.d("Response","carpark retrieval success");
        // then we fill the vacancies, where we have to do a key match
        retrieveVacancies(date_time, context);
        Log.d("Response","carpark vacancy retrieval success");
    }

    static void retrieveCarParks(Context context){
        int offset = 0;

        //create a request queue
        do {
            String URLpart1 = "https://data.gov.sg/api/action/datastore_search?offset=";
            String URLpart2 = "&resource_id=139a3035-e624-4f56-b63f-89ae28d4ae4c";
            String URL = URLpart1 + offset + URLpart2;

            //Log.d("Response", "URL is " + URL);

            RequestQueue requestQueue = Volley.newRequestQueue(context);

            //create json request
            JsonObjectRequest objectRequest = new JsonObjectRequest(
                    Request.Method.GET,
                    URL,
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            //Log.d("Response", "response is: " + response.toString());

                            try {
                                JSONObject result = response.getJSONObject("result");
                                //Log.d("Response", "results are: " + result.toString());
                                JSONArray records = result.getJSONArray("records");
                                //Log.d("Response", "records are: " + records.toString());

                                for (int i = 0; i < records.length(); i++) {
                                    JSONObject temp = records.getJSONObject(i);
                                    //Log.d("Response", "temp is " + temp.toString());
                                    CarPark entry = new CarPark(temp.getString("car_park_no"), temp.getString("address"), (float) temp.getDouble("x_coord"), (float) temp.getDouble("y_coord"));
                                    //Log.d("Response", "temp is " + entry.carpark_address);
                                    CarParkList.addCarPark(entry);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                                //Log.e("Response", "exception", e);
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

            offset = offset + 100;
        }while(offset < 3698);

        Log.d("Response", "end of retrieveCarParks");
    }

    static void retrieveVacancies(Context context){
        String timeStamp = Instant.now().toString();
        retrieveVacancies(timeStamp.substring(0,19), context);

    }

    static void retrieveVacancies(String date_time, Context context){

        String URL = "https://api.data.gov.sg/v1/transport/carpark-availability?date_time=";
        String ReqURL = URL + date_time;

        Log.d("Response", "URL is: "+ ReqURL);

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
                        //Log.d("Response", response.toString());
                        try{
                            JSONArray items = response.getJSONArray("items");
                            Log.d("Response", "items is: " + items.toString());
                            JSONObject itemsobject = items.getJSONObject(0);
                            Log.d("Response", "itemsobject is: " + itemsobject.toString());
                            JSONArray carpark_data = itemsobject.getJSONArray("carpark_data");
                            //Log.d("Response", "carparkdata are: " + carpark_data.toString());
                            Log.d("Response", "number of carparkdata entries are: "+ carpark_data.length());
                            for(int i = 0; i < carpark_data.length(); i++){
                                JSONObject temp = carpark_data.getJSONObject(i);
                                int index = CarParkList.findCarpark(temp.getString("carpark_number"));
                                //Log.d("Response", "the index is: "+ index);

                                JSONArray carpark_info = temp.getJSONArray("carpark_info");
                                JSONObject carpark_infoobject = carpark_info.getJSONObject(0);
                                //Log.d("Response", "carpark_infoobject is: " + carpark_infoobject.toString());
                                CarParkList.changeVacancy(carpark_infoobject.getInt("lots_available"), index);
                                CarParkList.setCapacity(carpark_infoobject.getInt("total_lots"), index);
                                Log.d("Response", "vacancies are: " + CarParkList.getCarParkList().get(index).vacancies);
                                //Log.d("Response", "capacity is: " + CarParkList.getCarParkList().get(index).capacity);

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
