package com.g2.androidapp.lotsoflots;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BookmarkAdapter extends ArrayAdapter<String> {

    public BookmarkAdapter( Context context, int resource) {
        super(context, resource);
    }

    public BookmarkAdapter( Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public BookmarkAdapter( Context context, int resource,  String[] objects) {
        super(context, resource, objects);
    }

    public BookmarkAdapter( Context context, int resource, int textViewResourceId,  String[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public BookmarkAdapter( Context context, int resource,  List<String> objects) {
        super(context, resource, objects);
    }

    public BookmarkAdapter( Context context, int resource, int textViewResourceId,  List<String> objects) {
        super(context, resource, textViewResourceId, objects);
    }

    @Override
    public View getView (int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LinearLayout view;
        if (convertView == null) {
            view = ((LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.bookmark_list_item, parent, false));
        } else {
            view = ((LinearLayout) convertView);
        }

        TextView textView = view.findViewById(R.id.bookmark_address);
        textView.setText(getItem(position));
        return view;
    }
}
