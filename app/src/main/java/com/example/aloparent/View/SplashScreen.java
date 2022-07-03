package com.example.aloparent.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.aloparent.R;
import com.example.aloparent.SoalKelas.SoalA1;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalshscreen);

        int splashScreenTime = 3000; //3 detik

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, SoalA1.class);
                SplashScreen.this.startActivity(intent);
                SplashScreen.this.finish();
            }
        },splashScreenTime);
    }
}