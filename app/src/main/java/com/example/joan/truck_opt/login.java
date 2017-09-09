package com.example.joan.truck_opt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class login extends AppCompatActivity implements View.OnClickListener {
    EditText text1;
    EditText text2;
    Button btn;
    String user, contra;
    private final String TAG = "LoginActivtyTest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        text1 = (EditText) findViewById(R.id.user1);
        text2 = (EditText) findViewById(R.id.pass);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                user = text1.getText().toString();
                contra = text2.getText().toString();
                api(user, contra);
                break;
        }
    }

    private void api(String user, String contra) {
        String url ="http://ordinadorcasa.no-ip.org:9001/?email="+user+"&password="+contra;
        Log.v(TAG, url);
        RequestQueue queue = Volley.newRequestQueue(this);

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        try {
                            JSONObject hola = new JSONObject(response);
                            String nomtest = hola.getString("nom");
                            Boolean driver = hola.getBoolean("driver");
                            if (driver) Log.v(TAG, "soc driver");
                            Log.v(TAG, "Response is: "+ nomtest);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v(TAG, "That didn't work!");
            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);


    }
}
