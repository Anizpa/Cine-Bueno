package com.example.cine.find_peliculas.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cine.R;
import com.example.cine.entities.Sala;

import java.util.ArrayList;
import java.util.List;

public class FindPeliculasAdapter extends RecyclerView.Adapter<FindPeliculasAdapter.ViewHolder> {

    private List<Sala> salas;
    private Context context;

    public FindPeliculasAdapter(Context context) {
        this.context = context;
        this.salas = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sala, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setItem(this.salas.get(position));
    }

    @Override
    public int getItemCount() {
        return salas.size();
    }

    public void addSalas(List<Sala> salas) {
        this.salas.clear();
        this.salas.addAll(salas);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView cine, horario;

        public ViewHolder(View itemView) {
            super(itemView);
        }

        public void setItem(Sala sala) {
            cine = itemView.findViewById(R.id.cine);
            horario = itemView.findViewById(R.id.horario);

            cine.setText(sala.getNombreCine());
            horario.setText(sala.getHorario());
        }
    }
}
