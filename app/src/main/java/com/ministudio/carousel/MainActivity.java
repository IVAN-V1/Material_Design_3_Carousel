package com.ministudio.carousel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.carousel.CarouselLayoutManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main);




        RecyclerView carouselRecyclerView = findViewById(R.id.Carousel_recyclerView);
        CarouselLayoutManager layoutManager = new CarouselLayoutManager();
        carouselRecyclerView.setLayoutManager(layoutManager);

        int[] imageResources = {
                R.drawable.card_cards, R.drawable.card_buttons, R.drawable.card_morado// Agrega tus recursos de imagen aquí
        };

        Carousel adapter = new Carousel(imageResources);
        carouselRecyclerView.setAdapter(adapter);


    }
}