package com.example.joan.truck_opt;

/**
 * Created by polvallsortiz on 9/09/17.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import agency.tango.materialintroscreen.SlideFragment;

public class CustomSlide extends SlideFragment {
    private CheckBox checkBox;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_custom_slide, container, false);
        checkBox = (CheckBox) view.findViewById(R.id.checkbox);
        return view;
    }

    @Override
    public int backgroundColor() {
        return R.color.backgroundcolor;
    }

    @Override
    public int buttonsColor() {
        return R.color.white;
    }

    @Override
    public boolean canMoveFurther() {
        return checkBox.isChecked();
    }

    @Override
    public String cantMoveFurtherErrorMessage() {
        return getString(R.string.errormessage);
    }
}
