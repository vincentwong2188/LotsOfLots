package com.g2.androidapp.lotsoflots;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;

public class FilterViewFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container , @Nullable Bundle savedInstantState){
        View view = inflater.inflate(R.layout.activity_filter_view_fragment,container,false);
        return view;
    }
}