package com.example.aloparent.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.aloparent.Artikel.Artikel2;
import com.example.aloparent.Artikel.Artikel4;
import com.example.aloparent.R;
import com.example.aloparent.SharedRefrence.SharedPrefManager;
import com.example.aloparent.SharedRefrence.UserModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.imageview.ShapeableImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Home extends AppCompatActivity {

    public static LinearLayout inputDataAnak;
    public static LinearLayout layout1;
    public static LinearLayout layout2;
    public static RelativeLayout dataAnak;
    private CircleImageView foto_profil_orangtua;
    private TextView tv_UserName;

    SeekBar homeSeekbar;

    // tekan back navbar 2 kali untuk keluar aplikasi

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


    //imtemt ke halaman artikel
    public void allArticel(View v){
        Intent intent = new Intent(Home.this, Artikel.class);
        startActivity(intent);
    }

    //imtemt ke halaman artikel 4
    public void artikel4(View v){
        Intent intent = new Intent(Home.this, Artikel4.class);
        startActivity(intent);
    }

    //imtemt ke halaman artikel 2
    public void artikelHome2(View v){
        Intent intent = new Intent(Home.this, Artikel2.class);
        startActivity(intent);
    }

    //intent ke halaman video hari ini
    public void allVideoToDay(View v){
        Intent intent = new Intent(Home.this, VideoHariIni.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setSelectedItemId(R.id.beranda);

        layout1 = (LinearLayout) findViewById(R.id.linearLayout1);
        dataAnak = (RelativeLayout) findViewById(R.id.data_anak);
        foto_profil_orangtua = findViewById(R.id.foto_profil_orangtua);
        tv_UserName = findViewById(R.id.tv_UserName);


        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.contoh_gambar_video1,"Agar di Usian 3 Tahun Cerdas, yuk Biasakan ini dirumah"));
        slideModels.add(new SlideModel(R.drawable.contoh_gambar_video2,"Agar di Usian 3 Tahun Cerdas, yuk Biasakan ini dirumah"));
        slideModels.add(new SlideModel(R.drawable.contoh_gambar_video1,"Agar di Usian 3 Tahun Cerdas, yuk Biasakan ini dirumah"));


        homeSeekbar = findViewById(R.id.homeSeekbar);
        homeSeekbar.setEnabled(false);

        ShapeableImageView tic_tac_toe = findViewById(R.id.tic_tac_toe);
        ShapeableImageView paint = findViewById(R.id.game_mewarnai);

        int totalSeekbar = 0;

        SharedPreferences mPrefs = getSharedPreferences("IDvalue",0);
        int progressLiniearA = mPrefs.getInt("progressA", 0);

        totalSeekbar += progressLiniearA;

        SharedPreferences mPrefs2 = getSharedPreferences("IDvalue2",0);
        int progressLiniearB = mPrefs2.getInt("progressB", 0);

        totalSeekbar += progressLiniearB;

        SharedPreferences mPrefs3 = getSharedPreferences("IDvalue3",0);
        int progressLiniearC = mPrefs3.getInt("progressC", 0);

        totalSeekbar += progressLiniearC;

        homeSeekbar.setProgress(totalSeekbar);

        SharedPreferences simpanDataAnak = getSharedPreferences("simpanDataAnak",0);
       int data_Anak = simpanDataAnak.getInt("DATA_ANAK",0 );

       tic_tac_toe.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               openApp("com.example.tictactoe");
           }
       });

       paint.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               openApp("com.raghav.paint");
           }
       });


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

    public void openApp(String packageName){
        Intent intent = new Intent(Intent.ACTION_MAIN);
        try {
            intent.setComponent(new ComponentName(packageName, packageName + ".MainActivity"));
            startActivity(intent);
        } catch(Exception e) {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse("market://details?id=" + packageName));
            startActivity(intent);
        }
    }
}