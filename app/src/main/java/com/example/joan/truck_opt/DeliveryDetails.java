package com.example.joan.truck_opt;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.FragmentActivity;


import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static com.android.volley.VolleyLog.TAG;

/**
 * Created by polvallsortiz on 9/09/17.
 */

public class DeliveryDetails extends FragmentActivity {
    LatLng originlatlng;
    LatLng destinylatlng;
    MapFragment mapFragment;
    Polyline line;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_delivery);
        originlatlng = new LatLng(41.390205,2.154007);
        destinylatlng = new LatLng(48.137154,11.576124);
        PlaceAutocompleteFragment autocompleteFragment1 = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment1);

        autocompleteFragment1.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                Log.i(TAG, "Place: " + place.getAddress());
                String origin = place.getAddress().toString();
                originlatlng = place.getLatLng();
                Log.i(TAG, "Resultat: " + origin);


            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Log.i(TAG, "An error occurred: " + status);
            }
        });


        PlaceAutocompleteFragment autocompleteFragment2 = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment2);

        autocompleteFragment2.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place2) {
                // TODO: Get info about the selected place.
                Log.i(TAG, "Place: " + place2.getAddress());
                String destiny = place2.getAddress().toString();
                destinylatlng = place2.getLatLng();
                Log.i(TAG, "Resultat: " + destiny);
                mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
                mapFragment.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap googleMap) {
                        PolylineOptions rectline = new PolylineOptions()
                                .add(originlatlng,destinylatlng);
                        googleMap.addPolyline(rectline);
                        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(originlatlng, 4));

                    }
                });
            }

            @Override
            public void onError(Status status2) {
                // TODO: Handle the error.
                Log.i(TAG, "An error occurred: " + status2);
            }
        });
        // ... get a map.



    }


}








