package com.example.cine.list_cines.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cine.R;
import com.example.cine.entities.Cines;
import com.example.cine.find_peliculas.view.FindPeliculasActivity;
import com.example.cine.list_all_cine_films.ListAllCineActivity;


import java.util.ArrayList;
import java.util.List;


public class ListCinesAdapter extends RecyclerView.Adapter<ListCinesAdapter.ViewHolder> {

    private List<Cines> cines;
    private Context context;

    public ListCinesAdapter(Context context) {
        cines = new ArrayList<>();
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cine, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListCinesAdapter.ViewHolder holder, int position) {
        holder.setItem(this.cines.get(position));
    }

    @Override
    public int getItemCount() {
        return this.cines.size();
    }

    public void addCines(List<Cines> cine){
        this.cines.clear();
        this.cines.addAll(cine);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView cineNombre;
        CardView cartaCine;

        public ViewHolder(View itemView) {
            super(itemView);
        }

        public void setItem(Cines cines) {
            cineNombre = itemView.findViewById(R.id.cineNombre);
            cartaCine = itemView.findViewById(R.id.cartaCine);

            cineNombre.setText(cines.getNombre());
            cartaCine.setOnClickListener(view -> {
                final Intent intent = new Intent(view.getContext(), ListAllCineActivity.class);
                intent.putExtra("idCine", cines.getIdCine());
                view.getContext().startActivity(intent);
            });
        }
    }
}
