package com.example.aloparent.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import com.example.aloparent.R;
import com.example.aloparent.databinding.ActivityDataAnakBinding;

public class DataAnak extends AppCompatActivity {

    SeekBar data_anak1;

    //intent ke update data anak
    public void toUpdateDataAnak(View v){
        Intent intent = new Intent(DataAnak.this, UpdateDataAnak.class);
        startActivity(intent);
    }

    // dari daftar data anak kembali ke screen home
    public void backFromDataAnak(View v){
        Intent intent = new Intent(DataAnak.this, Home.class);
        startActivity(intent);
    }

    ActivityDataAnakBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataAnakBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        data_anak1 = findViewById(R.id.data_anak_1);

        data_anak1.setEnabled(false);

        int pembelajranAnak1 = 0;

        SharedPreferences mPrefs = getSharedPreferences("IDvalue",0);
        int progressLiniearA = mPrefs.getInt("progressA", 0);
        pembelajranAnak1 +=progressLiniearA;

        SharedPreferences mPrefs2 = getSharedPreferences("IDvalue2",0);
        int progressLiniearB = mPrefs2.getInt("progressB", 0);
        pembelajranAnak1 +=progressLiniearB;

        SharedPreferences mPrefs3 = getSharedPreferences("IDvalue3",0);
        int progressLiniearC = mPrefs3.getInt("progressC", 0);
        pembelajranAnak1 +=progressLiniearC;

        data_anak1.setProgress(pembelajranAnak1);
    }
}