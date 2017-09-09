package com.example.joan.truck_opt;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

public class MainActivityDriver extends AppCompatActivity {
    private final String TAG = MainActivityDriver.class.toString();
    private RouteListAdapter routeListAdapter;
    private ListView routeList;
    private RequestQueue requestQueue;
    private final String BASE_URL = "http://ordinadorcasa.no-ip.org";
    SharedPreferences sp;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_driver);
        sp = getSharedPreferences("APP2", Context.MODE_PRIVATE);
        editor = sp.edit();
        routeListAdapter = new RouteListAdapter(this);
        requestQueue = Volley.newRequestQueue(this);
        refreshData();
        routeList = (ListView) findViewById(R.id.route_list);
        routeList.setAdapter(routeListAdapter);
    }

    protected String getRequestUrl() {
        //TODO Enter parameters
        String email = sp.getString("password", "");
        String password = sp.getString("currentUser", "");
        return BASE_URL + "/?email=" + email + "&password=" + password + "&cmd=mostrarRutas";
    }

    protected void refreshData() {
        routeListAdapter.clear();
        StringRequest request = new StringRequest(
                Request.Method.GET,
                getRequestUrl(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject r = new JSONObject(response);
                            JSONArray array = r.getJSONArray("rutasPosibles");
                            for (int i = 0; i < array.length(); i++){
                                Route route = unmarshallRoute(array.getJSONObject(i));
                                routeListAdapter.add(route);
                            }
                            Log.i(TAG, "Updated route list sucessfully");
                        } catch (JSONException e) {
                            Log.e(TAG, "Received malformed json");
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i(TAG, "Received error status code " + error.networkResponse.statusCode);
                    }
                }
        );
        requestQueue.add(request);
    }

    protected Route unmarshallRoute(JSONObject o) throws JSONException {
        return new Route(
                o.getString("From"),
                o.getString("To"),
                o.getDouble("Ganancia"),
                Arrays.asList(o.getString("Waypoints").split("|"))
        );
    }
}
