package com.example.joan.truck_opt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity implements View.OnClickListener {
    EditText text1 = (EditText) findViewById(R.id.user1);
    EditText text2 = (EditText) findViewById(R.id.pass);
    Button btn = (Button) findViewById(R.id.button);
    String user, contra;
    private final String TAG = "LoginActivtyTest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
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

    }
}
