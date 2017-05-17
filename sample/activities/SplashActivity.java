package com.cinecentre.cinecentrecinema.activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.cinecentre.cinecentrecinema.IntentStarter;
import com.cinecentre.cinecentrecinema.R;


public class SplashActivity extends AppCompatActivity {

    private static final long SPLASH_TIME = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                start();
            }
        }, SPLASH_TIME);
    }


    void start() {
        IntentStarter.navigateMain(this);
        finish();
    }
}