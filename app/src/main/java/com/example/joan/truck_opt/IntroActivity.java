package com.example.joan.truck_opt;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import agency.tango.materialintroscreen.MaterialIntroActivity;
import agency.tango.materialintroscreen.MessageButtonBehaviour;
import agency.tango.materialintroscreen.SlideFragment;
import agency.tango.materialintroscreen.SlideFragmentBuilder;
import agency.tango.materialintroscreen.animations.IViewTranslation;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class IntroActivity extends MaterialIntroActivity {

    @Override
        protected void attachBaseContext(Context newBase) {
            super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
        }
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            enableLastSlideAlphaExitTransition(true);

            getBackButtonTranslationWrapper()
                    .setEnterTranslation(new IViewTranslation() {
                        @Override
                        public void translate(View view, @FloatRange(from = 0, to = 1.0) float percentage) {
                            view.setAlpha(percentage);
                        }
                    });

            addSlide(new SlideFragmentBuilder()
                            .backgroundColor(R.color.first_slide_background)
                            .buttonsColor(R.color.first_slide_buttons)
                            .image(R.drawable.logowidth)
                            .title("TruckU")
                            .description("Optimizing the truck deliveries")
                            .build());

            addSlide(new SlideFragmentBuilder()
                    .backgroundColor(R.color.secondprimary)
                    .buttonsColor(R.color.secondicons)
                    .image(R.drawable.introactivitysecondslide)
                    .title("Truck drivers welcome!")
                    .description("Get a maximum profit of your truck trips")
                    .build());
        
            addSlide(new SlideFragmentBuilder()
                            .backgroundColor(R.color.dollarback)
                            .buttonsColor(R.color.dollarbuttons)
                            .neededPermissions(new String[]{Manifest.permission.INTERNET,Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION})
                            .image(R.drawable.introactivitydollar)
                            .title("Do you want to send something?")
                            .description("Get the best fares")
                            .build());
            addSlide(new SlideFragmentBuilder()
                    .backgroundColor(R.color.customback)
                    .buttonsColor(R.color.custombuttons)
                    .image(R.drawable.customslide2)
                    .title("Eco-Friendly")
                    .description("You can reduce the CO2 footprint, never a truck runs empty!")
                    .build());
            addSlide(new CustomSlide());

            addSlide(new SlideFragmentBuilder()
                    .backgroundColor(R.color.first_slide_background)
                    .buttonsColor(R.color.first_slide_buttons)
                    .title("Cool!")
                    .description("You're ready to use it, you will see it's so easy!")
                    .build());
        }

        @Override
        public void onFinish() {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
}
