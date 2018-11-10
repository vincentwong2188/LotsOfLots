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


    public static String teststring;


    APIRetrieveSystem(){ //constructor

    }
    static void retrieveall(Context context){
        String timeStamp = Instant.now().toString();
        retrieveall(timeStamp, context);
    }

    static void retrieveall(String date_time, Context context){
        //first we fill the carpark list array with carpark objects (with no vacancies yet)
        retrieveCarParks(context);
        // then we fill the vacancies, where we have to do a key match
        retrieveVacancies(date_time, context);
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
                            JSONObject result = response.getJSONObject("result");
                            JSONArray records = result.getJSONArray("records");

                            teststring = result.toString();

                            for(int i = 0; i < records.length(); i++){
                                JSONObject temp = records.getJSONObject(i);
                                CarPark entry = new CarPark();
                                entry.carpark_address = temp.getString("address");
                                entry.carpark_number = temp.getString("car_park_no");
                                entry.x_coord = (float) temp.getDouble("x_coord");
                                entry.y_coord = (float) temp.getDouble("y_coord");
                                entry.lat = CoordinateConverter.convert(entry.y_coord, entry.x_coord).getLatitude();
                                entry.lng = CoordinateConverter.convert(entry.y_coord, entry.x_coord).getLongitude();
                                CarParkList.addCarPark(entry);

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

    static void retrieveVacancies(Context context){
        String timeStamp = Instant.now().toString();
        retrieveVacancies(timeStamp.substring(0,19), context);

    }

    static void retrieveVacancies(String date_time, Context context){

        String URL = "https://api.data.gov.sg/v1/transport/carpark-availability?date_time=";
        String ReqURL = URL + date_time;

        //teststring = ReqURL;

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
                            JSONArray items = response.getJSONArray("items");
                            JSONObject itemsobject = items.getJSONObject(0);
                            JSONArray carpark_data = itemsobject.getJSONArray("carpark_data");
                            teststring = response.toString();

                            for(int i = 0; i < carpark_data.length(); i++){
                                JSONObject temp = carpark_data.getJSONObject(i);
                                int index = CarParkList.findCarpark(temp.getString("carpark_number"));

                                JSONArray carpark_info = temp.getJSONArray("carpark_info");
                                JSONObject carpark_infoobject = carpark_info.getJSONObject(0);
                                CarParkList.changeVacancy(carpark_infoobject.getInt("lots_available"), index);

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
