package com.example.joan.truck_opt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.common.api.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class MainActivityUser extends ActionBarActivity implements View.OnClickListener {
    PacketListAdapter packetListAdapter;
    ListView packetList;
    SharedPreferences sp;
    private static final String TAG = "MainActivityUser";
    SharedPreferences.Editor editor;
    FloatingActionButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        packetList = (ListView) findViewById(R.id.packet_list);
        packetListAdapter = new PacketListAdapter(this);
        sp = getSharedPreferences("APP2", Context.MODE_PRIVATE);
        editor = sp.edit();
        btn = (FloatingActionButton) findViewById(R.id.addone);
        btn.setOnClickListener(this);
        testData();
    }
    private void testData(){
        String pass = sp.getString("password", "");
        String email = sp.getString("currentUser", "");
        String url = "http://ordinadorcasa.no-ip.org:9001/?email=" + email + "&password=" + pass + "&cmd=verPedidos";
        Log.v(TAG, "url "+ url);
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject userdownloaded = new JSONObject(response);
                            JSONArray pedidos = userdownloaded.getJSONArray("pedidos");
                            for (int i = 0; i < pedidos.length(); ++ i){
                                JSONObject o = pedidos.getJSONObject(i);
                                Delivery delivery = new Delivery(
                                        0,
                                        o.getString("From"),
                                        o.getString("To"),
                                        Arrays.asList(o.getString("Notifications").split(";"))
                                );
                                packetListAdapter.add(delivery);
                            }

                            packetList.setAdapter(packetListAdapter);


                            editor.apply();

                        } catch (JSONException e) {
                            Log.v(TAG, "detecto el error");
                            e.printStackTrace();
                        }

                    }
                }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v(TAG, "That didn't work!");

            }

        });
        queue.add(stringRequest);

     /*   for (int i = 0; i < 100; i=i+2) {
            packetListAdapter.add(new Delivery(i, "Here", "Th3ere", Arrays.asList("A", "B")));
            packetListAdapter.add(new Delivery(i+1, "Anotha one" + i, "Th3ere", Arrays.asList("A", "B")));
        } */
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.addone:
                Intent i = new Intent(this, DeliveryDetails.class);
                startActivity(i);
                break;
        }
    }
}
