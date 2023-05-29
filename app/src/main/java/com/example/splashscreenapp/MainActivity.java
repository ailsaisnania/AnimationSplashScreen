package com.example.splashscreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    ImageView name, bg;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.apple);
        bg = findViewById(R.id.img);
        lottieAnimationView = findViewById(R.id.lottie);

        bg.animate().translationY(-1600).setDuration(4000);
        name.animate().translationY(1400).setDuration(2000).setStartDelay(1000);
        lottieAnimationView.animate().setDuration(3000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
                finish();
            }
        },4000);

    }
}