package com.example.hangin.view.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.example.hangin.R;
import com.example.hangin.view.auth.AuthActivity;


public class SplashActivity extends AppCompatActivity {


    private static final int Splash_Time = 3000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                        Intent i1 = new Intent(SplashActivity.this, AuthActivity.class);
                    startActivity(i1);
                    finish();
                }
            }, Splash_Time);
        }

}
