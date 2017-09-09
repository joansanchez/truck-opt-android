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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Biel on 9/9/2017.
 */

public class PacketListAdapter extends ArrayAdapter<Delivery> {
    List<Delivery> deliveryList = new ArrayList<>();
    public PacketListAdapter(@NonNull Context context) {
        super(context, R.layout.rowlayout);
    }

    @Override
    public void add(Delivery delivery) {
        deliveryList.add(delivery);
    }

    @Override
    public void remove(Delivery o) {
        deliveryList.remove(o);
    }

    @Override
    public int getCount() {
        return deliveryList.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rowlayout, parent, false);
        TextView from = (TextView) view.findViewById(R.id.source);
        TextView to = (TextView) view.findViewById(R.id.destiny);
        TextView notification = (TextView) view.findViewById(R.id.notification);
        Delivery delivery = deliveryList.get(position);
        from.setText(delivery.getFrom());
        to.setText(delivery.getTo());
        notification.setText(delivery.getNotifications().get(delivery.getNotifications().size()-1));
        return view;
    }
}
