package com.example.joan.truck_opt;

import android.app.Application;
import android.content.Intent;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by polvallsortiz on 9/09/17.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/roboto.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        Intent intent = new Intent(this, IntroActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
