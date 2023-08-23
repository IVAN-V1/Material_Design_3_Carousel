package com.ministudio.carousel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Carousel extends RecyclerView.Adapter<Carousel.ViewHolder> {


    private int image[];


    public Carousel( int imagenes[]){
        this.image=imagenes;

    }


   // El método onCreateViewHolder es un método importante en una clase que implementa
   // un RecyclerView.Adapter en Android.
    @NonNull
    @Override
    public Carousel.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pantalla_carousel, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Carousel.ViewHolder holder, int position) {
        holder.imageView.setImageResource(image[position]);

    }

    @Override
    public int getItemCount() {
        return image.length;
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{

        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.carousel_image_view);
        }
    }
}
