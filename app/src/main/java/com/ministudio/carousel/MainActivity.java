package com.ministudio.carousel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.ministudio.carousel.Actividades_Carousel.Actividad_Carousel_2;
import com.ministudio.carousel.Actividades_Carousel.Actividad_carousel_1;
import com.ministudio.carousel.Actividades_Carousel.Actividad_carousel_3;

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


        adapter.setOnItemClickListener(new Carousel.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // Aquí puedes definir el código para redireccionar a diferentes actividades
                // según la posición de la imagen seleccionada.

                Intent intent;

                if (position == 0) {
                    // Redirige a PrimeraActividad si se selecciona la primera imagen.
                    intent = new Intent(MainActivity.this, Actividad_carousel_1.class);
                } else if (position == 1) {
                    // Redirige a SegundaActividad si se selecciona la segunda imagen.
                    intent = new Intent(MainActivity.this, Actividad_Carousel_2.class);
                } else {
                    // Manejo de otras posiciones si es necesario.
                    intent = new Intent(MainActivity.this, Actividad_carousel_3.class);
                }

                // Pasa la posición de la imagen seleccionada a la actividad.
                intent.putExtra("image_position", position);

                startActivity(intent);
            }
        });



    }
}