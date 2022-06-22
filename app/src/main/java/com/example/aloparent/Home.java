package com.example.aloparent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    public static LinearLayout inputDataAnak;
    public static LinearLayout layout1;
    public static LinearLayout layout2;
    public static RelativeLayout dataAnak;


    //inetnt ke profil orang tua
    public void ToProfile(View v){
        Intent intent = new Intent(Home.this, ProfileScreen.class);
        startActivity(intent);
    }

    //inten ke halaman notikasi
    public void toNotifikasi(View v){
        Intent intent = new Intent(Home.this, Notifikasi.class);
        startActivity(intent);
    }

    //imtemt ke halaman artikel
    public void allArticel(View v){
        Intent intent = new Intent(Home.this, Artikel.class);
        startActivity(intent);
    }

    //ke halaman semua data anak
    public void anotherChildData(View v){
        Intent intent = new Intent(Home.this, DataAnak.class);
        startActivity(intent);
    }

    //intent ke halaman favorit kesehatan
    public void kesehatanFavorit(View v){
        Intent intent = new Intent(Home.this, favorite.class);
        startActivity(intent);
    }

    // intent ke halaman semua permaianan
    public void allGames(View v){
        Intent intent = new Intent(Home.this, Permainan.class);
        startActivity(intent);
    }

    //intent ke halaman video hari ini
    public void allVideoToDay(View v){
        Intent intent = new Intent(Home.this, VideoHariIni.class);
        startActivity(intent);
    }

    // intent ke halaman input data anak
    public void inputDataAnak(View v){
        Intent intent = new Intent(Home.this, UpdateDataAnak.class);
        startActivity(intent);
    }

    public void profile(View v){
        Intent intent = new Intent(Home.this, ProfileScreen.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.beranda);

        inputDataAnak = (LinearLayout) findViewById(R.id.tambahDataAnak);
        layout1 = (LinearLayout) findViewById(R.id.linearLayout1);
        dataAnak = (RelativeLayout) findViewById(R.id.data_anak);
        layout2 = (LinearLayout) findViewById(R.id.linierlayout2);

        ImageSlider imageSlider = findViewById(R.id.view_pager1);

        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.contoh_gambar_video1,"Agra di Usian 3 Tahun Cerdas, yuk Biasakan ini dirumah"));
        slideModels.add(new SlideModel(R.drawable.contoh_gambar_video2,"Agra di Usian 3 Tahun Cerdas, yuk Biasakan ini dirumah"));
        slideModels.add(new SlideModel(R.drawable.contoh_gambar_video1,"Agra di Usian 3 Tahun Cerdas, yuk Biasakan ini dirumah"));

        imageSlider.setImageList(slideModels,true);


       bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.beranda:
                    return true;
                    case R.id.konseling:
                        startActivity(new Intent(getApplicationContext(), Konseling.class));
                        overridePendingTransition(0,0);
                    return true;
                    case R.id.kelas:
                        startActivity(new Intent(getApplicationContext(), Kelas.class));
                        overridePendingTransition(0,0);
                    return true;
                    case R.id.edukasi:
                        startActivity(new Intent(getApplicationContext(), Edukasi.class));
                        overridePendingTransition(0,0);
                    return true;

                }
                return false;
            }
        });
    }
}