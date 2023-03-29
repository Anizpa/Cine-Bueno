package com.example.cine.list_cines.presenter;

import com.example.cine.entities.Cines;
import com.example.cine.entities.Peliculas;
import com.example.cine.list_cines.ListCinesContract;
import com.example.cine.list_cines.model.ListCinesModel;
import com.example.cine.list_peliculas.ListPeliculasContract;

import java.util.List;


public class ListCinesPresenter implements ListCinesContract.Presenter {
    private ListCinesModel listCinesModel;
    private ListCinesContract.View view;

    public ListCinesPresenter(ListCinesContract.View view) {
        this.listCinesModel = new ListCinesModel();
        this.view = view;
    }

    @Override
    public void listCines() {
        listCinesModel.listCinesWS(new ListCinesContract.Model.OnLstCinesListener() {
            @Override
            public void onSuccess(List<Cines> listCines) {
                if(listCines != null && listCines.size() > 0){
                    view.successListCines(listCines);
                }else{
                    view.failureListCines("No ha llegado ningun dato :(");
                }
            }

            @Override
            public void onFailure(String err) {
                view.failureListCines(err);
            }
        });
    }
}
