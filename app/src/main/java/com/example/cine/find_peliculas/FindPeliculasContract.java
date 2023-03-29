package com.example.cine.find_peliculas;

import com.example.cine.entities.ListPeliculasRequest;
import com.example.cine.entities.PeliculaFicha;
import com.example.cine.entities.Peliculas;
import com.example.cine.list_peliculas.ListPeliculasContract;

import java.util.List;

public interface FindPeliculasContract {
    public interface View {
        void successFindPeliculas(PeliculaFicha fichaPelicula);

        void failureFindPeliculas(String err);
    }

    public interface Model {
        interface OnFindPeliculasListener {
            void onSuccess(PeliculaFicha fichaPelicula);

            void onFailure(String err);
        }

        void findPeliculasWS(int idPelicula,
                             OnFindPeliculasListener onFindPeliculasListener);
    }

    public interface Presenter {
        //Caso de uso
        void findPeliculas(int idPelicula);
    }
}
