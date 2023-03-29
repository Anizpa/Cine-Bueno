package com.example.cine.find_peliculas.presenter;

import com.example.cine.entities.PeliculaFicha;
import com.example.cine.find_peliculas.FindPeliculasContract;
import com.example.cine.find_peliculas.model.FindPeliculasModel;

public class FindPeliculasPresenter implements FindPeliculasContract.Presenter {

    private FindPeliculasContract.View view;
    private FindPeliculasModel model;

    public FindPeliculasPresenter(FindPeliculasContract.View view) {
        this.view = view;
        this.model = new FindPeliculasModel();
    }

    @Override
    public void findPeliculas(int idPelicula) {
        model.findPeliculasWS(idPelicula, new FindPeliculasContract.Model.OnFindPeliculasListener() {
            @Override
            public void onSuccess(PeliculaFicha fichaPelicula) {
                if (fichaPelicula != null) {
                    view.successFindPeliculas(fichaPelicula);
                } else {
                    view.failureFindPeliculas("No hay datos");
                }
            }

            @Override
            public void onFailure(String err) {
                view.failureFindPeliculas(err);
            }
        });
    }
}
