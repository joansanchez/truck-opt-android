package com.example.joan.truck_opt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {
    private static final String TAG = "SplashActivity";
    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        final Intent i = new Intent(this, IntroActivity.class);
        final Intent l = new Intent(this, LoginActivity.class);
        final Intent p = new Intent(this, MainActivityUser.class);
        sp = getSharedPreferences("APP2", Context.MODE_PRIVATE);
        editor = sp.edit();
        final Boolean firstuse = sp.getBoolean("firstuse",true);
        String actual = sp.getString("currentUser",null);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                if (firstuse) {
                    editor.putBoolean("firstuse", false);
                    editor.apply();
                    startActivity(i);
                }
                else {
                    if (sp.getString("currentUser", "").length() != 0) startActivity(p);
                    else{
                        startActivity(l);
                    }

                }
            }
        }, 1500);


    }
}
