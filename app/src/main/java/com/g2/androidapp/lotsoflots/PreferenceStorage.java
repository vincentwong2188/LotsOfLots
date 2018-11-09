package com.g2.androidapp.lotsoflots;

import java.util.ArrayList;

public class PreferenceStorage {

    protected String Preference;
    private static ArrayList<Preference> preferenceArrayList = new ArrayList<>(0);



    /** adding getting the preference array list*/
    public static ArrayList<Preference> getPreference() {
        return preferenceArrayList;
    }


    /** when setting a new preference, i added it into the preference array list*/

    public static void setPreference(Preference preference){
      preferenceArrayList.add(preference);

    }

}