package com.ministudio.carousel;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ministudio.carousel.Actividades_Carousel.Actividad_carousel_1;

public class Carousel extends RecyclerView.Adapter<Carousel.ViewHolder> {


    private int image[];

    private OnItemClickListener onItemClickListener;



    // Método para configurar el escuchador de eventos
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    // Define la interfaz para el escuchador de eventos
    public interface OnItemClickListener {
        void onItemClick(int position);
    }


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


        // Configura el clic en la imagen
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(position);
                }
            }
        });





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
