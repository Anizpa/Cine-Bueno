package com.example.cine.list_peliculas.view;

import android.content.Context;
import android.service.autofill.Dataset;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cine.R;
import com.example.cine.entities.Peliculas;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListPeliculasAdapter extends RecyclerView.Adapter<ListPeliculasAdapter.ViewHolder> {

    private List<Peliculas> peliculas;
    private List<Peliculas> busqueda;
    private Context context;

    public ListPeliculasAdapter(Context context) {
        this.context = context;
        peliculas = new ArrayList<>();
        busqueda = new ArrayList<>();
        busqueda.addAll(peliculas);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pelicula, parent, false);

        return new ViewHolder(view);
    }

    public void filtrado(String txtBuscar) {
        int longitud = txtBuscar.length();
        if (longitud == 0) {
            peliculas.clear();

            for (int i = 0; i < 12; i++) {
                peliculas.add(busqueda.get(i));
            }

        } else {
            List<Peliculas> coleccion = peliculas.stream().filter(i -> i.getTitulo().toLowerCase()
                    .contains(txtBuscar.toLowerCase())).collect(Collectors.toList());
            this.busqueda.addAll(peliculas);
            peliculas.clear();
            peliculas.addAll(coleccion);
        }
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setItem(this.peliculas.get(position));
        /*Peliculas pelicula = peliculas.get(position);
        holder.nombre.setText(pelicula.getTitulo());
        holder.categoria.setText(pelicula.getCategoria());
        holder.valoracion.setText(Double.toString(pelicula.getValoracion()));
        Picasso.get().load(pelicula.getImagen()).into(holder.foto);*/


    }

    @Override
    public int getItemCount() {
        return peliculas.size();
    }

    public void addPeliculas(List<Peliculas> listPeliculas) {
        peliculas.clear();
        peliculas.addAll(listPeliculas);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView foto;
        private TextView nombre;
        private TextView categoria;
        private TextView valoracion;


        public ViewHolder(View itemView) {
            super(itemView);

            /*foto = itemView.findViewById(R.id.imagenPeli);
            nombre = itemView.findViewById(R.id.nombrePeli);
            categoria = itemView.findViewById(R.id.categoria);
            valoracion = itemView.findViewById(R.id.valoracion);*/

        }
        public String generateUrl(String s) {
            String[] p = s.split("/");
            String link = "https://drive.google.com/uc?export=download&id=" + p[5];
            return link;
        }

        public void setItem(Peliculas pelicula) {
            foto = itemView.findViewById(R.id.imagenPeli);
            nombre = itemView.findViewById(R.id.nombrePeli);
            categoria = itemView.findViewById(R.id.categoria);
            valoracion = itemView.findViewById(R.id.valoracion);

            nombre.setText(pelicula.getTitulo());
            categoria.setText(pelicula.getCategoria());
            valoracion.setText(Double.toString(pelicula.getValoracion()));
            System.out.println(pelicula.getImagen());


            String ulrImage = generateUrl(pelicula.getImagen());
            Picasso.get().load(ulrImage).into(this.foto);
        }
    }
}
