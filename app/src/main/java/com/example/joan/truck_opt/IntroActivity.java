package com.example.joan.truck_opt;

import android.Manifest;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import agency.tango.materialintroscreen.MaterialIntroActivity;
import agency.tango.materialintroscreen.MessageButtonBehaviour;
import agency.tango.materialintroscreen.SlideFragmentBuilder;
import agency.tango.materialintroscreen.animations.IViewTranslation;

public class IntroActivity extends MaterialIntroActivity {

    @Override
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
                    .description("App only available for professional truck drivers")
                    .build(),
                new MessageButtonBehaviour(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showMessage("Enter to our platform trucku.com");
                    }
                }, "What if I want to send?"));

        
            addSlide(new SlideFragmentBuilder()
                            .backgroundColor(R.color.first_slide_background)
                            .buttonsColor(R.color.first_slide_buttons)
                            .neededPermissions(new String[]{Manifest.permission.INTERNET,Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION})
                            .image(R.drawable.ic_delivery_truck)
                            .title("We provide best tools")
                            .description("ever")
                            .build(),
                    new MessageButtonBehaviour(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            showMessage("Try us!");
                        }
                    }, "Tools"));

            addSlide(new SlideFragmentBuilder()
                    .backgroundColor(R.color.first_slide_background)
                    .buttonsColor(R.color.first_slide_buttons)
                    .title("That's it")
                    .description("Would you join us?")
                    .build());
        }

        @Override
        public void onFinish() {
            super.onFinish();
            Toast.makeText(this, "Try this library in your project! :)", Toast.LENGTH_SHORT).show();
        }
}
