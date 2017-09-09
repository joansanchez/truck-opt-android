package com.example.joan.truck_opt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        final Intent i = new Intent(this, IntroActivity.class);
        final Intent l = new Intent(this, LoginActivity.class);
        final Intent p = new Intent(this, MainActivity.class);
        SharedPreferences sp;
        SharedPreferences.Editor editor;
        sp = getSharedPreferences("APP", Context.MODE_PRIVATE);
        editor = sp.edit();
        Boolean firstuse = sp.getBoolean("firstuse",true);
        String actual = sp.getString("currentUser","");
        if (firstuse) {
            editor.putBoolean("firstuse", false);
            startActivity(i);
        }
        else {
            if (actual.length() != 0){
                startActivity(l);
            }
            else startActivity(p);
        }
    }
}
