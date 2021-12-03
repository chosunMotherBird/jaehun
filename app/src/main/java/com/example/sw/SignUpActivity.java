package com.example.sw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {
    private Button sGoBack, sSignUp;
    private EditText sEmail, SName, sPw, sPhone;
    private boolean okSign=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        sGoBack=findViewById(R.id.btn_sGoBack);
        sSignUp=findViewById(R.id.btn_sSignUp);
        sSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(okSign) {
                    //로그인하고
                    finish();
                }
            }
        });
        sGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}