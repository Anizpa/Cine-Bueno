package com.example.cine.list_peliculas.presenter;

import com.example.cine.entities.ListPeliculasRequest;
import com.example.cine.entities.Peliculas;
import com.example.cine.list_peliculas.ListPeliculasContract;
import com.example.cine.list_peliculas.model.ListPeliculasModel;

import java.util.ArrayList;
import java.util.List;

public class ListPeliculasPresenter implements ListPeliculasContract.Presenter {

    private ListPeliculasModel listPeliculasModel;
    private ListPeliculasContract.View view;

    public ListPeliculasPresenter(ListPeliculasContract.View view) {
        this.listPeliculasModel = new ListPeliculasModel();
        this.view = view;
    }

    @Override
    public void listPeliculas(ListPeliculasRequest request) {
        listPeliculasModel.listPeliculasWS(request, new ListPeliculasContract.Model.OnLstPeliculasListener() {
            @Override
            public void onSuccess(List<Peliculas> listPeliculas) {
                if(listPeliculas != null && listPeliculas.size() > 0){
                    view.successListPeliculas(listPeliculas);
                }else{
                    view.failureListPeliculas("No ha llegado ningun dato :(");
                }
            }

            @Override
            public void onFailure(String err) {
                view.failureListPeliculas(err);
            }
        });
    }
}
