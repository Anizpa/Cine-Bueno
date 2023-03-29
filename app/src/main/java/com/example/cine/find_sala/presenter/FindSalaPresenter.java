package com.example.cine.find_sala.presenter;

import com.example.cine.entities.Sala;
import com.example.cine.find_sala.FindSalaContract;
import com.example.cine.find_sala.model.FindSalaModel;

public class FindSalaPresenter implements FindSalaContract.Presenter {

    private FindSalaContract.View view;
    private FindSalaModel model;

    public FindSalaPresenter(FindSalaContract.View view) {
        this.view = view;
        model = new FindSalaModel();
    }

    @Override
    public void findSala(int idSala) {
        model.findSalaWS(idSala, new FindSalaContract.Model.OnFindSalaListener() {
            @Override
            public void onSuccess(Sala sala) {
                if (sala != null) {
                    view.successFindSala(sala);
                } else {
                    view.failureFindSala("No ha llegado ningún dato.");
                }
            }

            @Override
            public void onFailure(String err) {
                view.failureFindSala(err);
            }
        });
    }
}
