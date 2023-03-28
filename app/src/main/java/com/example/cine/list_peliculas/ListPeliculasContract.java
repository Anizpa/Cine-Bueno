package com.example.cine.list_peliculas;

import com.example.cine.entities.ListPeliculasRequest;
import com.example.cine.entities.Peliculas;

import java.util.List;


public interface ListPeliculasContract {
    public interface View {
        void successListPeliculas(List<Peliculas> listPeliculas);

        void failureListPeliculas(String err);
    }

    public interface Model {
        interface OnLstPeliculasListener {
            void onSuccess(List<Peliculas> listPeliculas);

            void onFailure(String err);
        }

        void listPeliculasWS(ListPeliculasRequest request,
                             OnLstPeliculasListener onLstPeliculasListener);
    }

    public interface Presenter {
        //Caso de uso
        void listPeliculas(ListPeliculasRequest request);
    }
}
