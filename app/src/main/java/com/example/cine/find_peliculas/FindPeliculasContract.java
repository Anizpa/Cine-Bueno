package com.example.cine.find_peliculas;

import com.example.cine.entities.ListPeliculasRequest;
import com.example.cine.entities.Peliculas;
import com.example.cine.list_peliculas.ListPeliculasContract;

import java.util.List;

public interface FindPeliculasContract {
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
                             ListPeliculasContract.Model.OnLstPeliculasListener onLstPeliculasListener);
    }

    public interface Presenter {
        //Caso de uso
        void listPeliculas(ListPeliculasRequest request);
    }
}
