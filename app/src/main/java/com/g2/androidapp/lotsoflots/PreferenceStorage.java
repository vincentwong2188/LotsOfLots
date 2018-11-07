package com.g2.androidapp.lotsoflots;

import java.util.ArrayList;
public class PreferenceStorage {

    String Preference;
    private ArrayList<Preference> preferenceArrayList = new ArrayList<>(0);



    /** adding getting the preference array list*/
    public ArrayList<Preference> getPreference() {
        return preferenceArrayList;
    }


    /** when setting a new preference, i added it into the preference array list*/

    public void setPreference(String preference){
        this.Preference = preference;
        preferenceArrayList.add(new Preference(preference));

    }

}


