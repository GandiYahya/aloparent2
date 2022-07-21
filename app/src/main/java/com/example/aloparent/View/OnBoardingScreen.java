package com.example.aloparent.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.example.aloparent.Adapter.SlideViewPagerAdapter;
import com.example.aloparent.R;
import com.example.aloparent.SharedRefrence.SharedPrefManager;

public class OnBoardingScreen extends AppCompatActivity {

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            Intent a = new Intent(Intent.ACTION_MAIN);
            a.addCategory(Intent.CATEGORY_HOME);
            a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(a);
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Tekan Sekali lagi Untuk Keluar", Toast.LENGTH_SHORT).show();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }


    ViewPager viewPager;
    SlideViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding_screen);

        // shared refrence
        final SharedPrefManager prefManager = new SharedPrefManager(getApplicationContext());
        Boolean isLoggedIn = prefManager.IsUserLoggedIn();

        // jika sudah login dan disaat aplikasi ditutup maka masuk ke screen home
        if (isLoggedIn){
            startActivity(new Intent(getApplicationContext(),Home.class));
        }

        viewPager=findViewById(R.id.viepager);
        adapter = new SlideViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        if(IsOpenAlready()){
            Intent intent = new Intent(OnBoardingScreen.this,LoginScreen.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }else {
            SharedPreferences.Editor editor=getSharedPreferences("slide",MODE_PRIVATE).edit();
            editor.putBoolean("slide",true);
            editor.commit();
        }
    }

    private boolean IsOpenAlready() {

        SharedPreferences sharedPreferences = getSharedPreferences("slide",MODE_PRIVATE);
        boolean result = sharedPreferences.getBoolean("slide",false);
        return result;
    }
}