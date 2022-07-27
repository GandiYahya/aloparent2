package com.example.aloparent.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.aloparent.View.Home;
import com.example.aloparent.R;

public class SlideViewPagerAdapter extends PagerAdapter {

    Context ctx;

    public SlideViewPagerAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_screen,container,false);

        ImageView logo = view.findViewById(R.id.logo);

        ImageView ind1 = view.findViewById(R.id.ind1);
        ImageView ind2 = view.findViewById(R.id.ind2);
        ImageView ind3 = view.findViewById(R.id.ind3);

        TextView title = view.findViewById(R.id.title);
        TextView desc = view.findViewById(R.id.desc);

        Button btn = view.findViewById(R.id.btnStarted);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx, Home.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                ctx.startActivity(intent);
            }
        });

        switch (position){
            case 0:
                logo.setImageResource(R.drawable.onboarding1);
                ind1.setImageResource(R.drawable.dot_selected);
                ind2.setImageResource(R.drawable.dot_unselected);
                ind3.setImageResource(R.drawable.dot_unselected);

                title.setText("Edukasi Cara Mendidik Anak");
                desc.setText("aloparent akan membantu orang tua untuk mendapatkan informasi untuk mengedukasi anak");
                break;
            case 1:
                logo.setImageResource(R.drawable.onboarding2);
                ind1.setImageResource(R.drawable.dot_unselected);
                ind2.setImageResource(R.drawable.dot_selected);
                ind3.setImageResource(R.drawable.dot_unselected);

                title.setText("Kelas pembelajaran ");
                desc.setText("Aloparent menyediakan Pembelajaran untuk anak tentang problem solving, computational thinking, dan creativity");
                break;
            case 2:
                logo.setImageResource(R.drawable.onboarding3);
                ind1.setImageResource(R.drawable.dot_unselected);
                ind2.setImageResource(R.drawable.dot_unselected);
                ind3.setImageResource(R.drawable.dot_selected);

                btn.setText("Mulai");

                title.setText("Permainan Mengedukasi");
                desc.setText("Dengan aloparent anak bermain sekalagus belajar");
                break;


        }

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
