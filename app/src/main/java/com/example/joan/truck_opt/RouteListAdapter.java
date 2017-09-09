package com.example.joan.truck_opt;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Biel on 9/9/2017.
 */

public class RouteListAdapter extends ArrayAdapter<Route> {

    public RouteListAdapter(@NonNull Context context) {
        super(context, R.layout.route_row_layout);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.route_row_layout, parent);
        TextView text = (TextView) view.findViewById(R.id.route_info);
        Route route = getItem(position);
        text.setText(route.toString());
        return view;
    }
}
